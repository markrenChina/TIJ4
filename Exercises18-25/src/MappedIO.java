import java.io.*;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.util.stream.Stream;

public class MappedIO {
    private static int numOfInts = 4000000;
    private static int numOfBuffInts = 200000;

    private abstract static class Tester {
        private String name;

        public Tester(String name) {
            this.name = name;
        }

        public void runTest() {
            try {
                System.out.print(name + ": ");
                var start = System.nanoTime();
                test();
                var duration = System.nanoTime() - start;
                System.out.format("%.2f\n", duration / 1.0e9);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public abstract void test() throws IOException;
    }

    private static final Tester[] testers = {
            new Tester("Stream Write") {
                @Override
                public void test() throws IOException {
                    DataOutputStream dos = new DataOutputStream(
                            new BufferedOutputStream(
                                    new FileOutputStream(new File("temp.tmp"))
                            )
                    );

                    Stream.iterate(0,i -> i++).limit(numOfInts).forEach(i -> {
                        try {
                            dos.writeInt(i);
                        }catch (IOException e){
                            throw new RuntimeException(e);
                        }
                    });
                    dos.close();
                }
            },
            new Tester("Mapped Write") {
                @Override
                public void test() throws IOException {
                    FileChannel fileChannel = new RandomAccessFile("temp.tmp","rw").getChannel();
                    IntBuffer intBuffer = fileChannel.map(
                            FileChannel.MapMode.READ_WRITE,0,fileChannel.size()
                    ).asIntBuffer();
                    Stream.iterate(0,i -> i++).limit(numOfInts).forEach(intBuffer::put);
                    fileChannel.close();
                }
            },
            new Tester("Stream Reader") {
                @Override
                public void test() throws IOException {
                    DataInputStream dis = new DataInputStream(
                            new BufferedInputStream(
                                    new FileInputStream("temp.tmp")
                            )
                    );
                    Stream.iterate(0,i -> i++).limit(numOfInts).forEach(i -> {
                        try {
                            dis.readInt();
                        }catch (IOException e){
                            throw new RuntimeException(e);
                        }
                    });
                    dis.close();
                }
            },
            new Tester("Mapped Read") {
                @Override
                public void test() throws IOException {
                    FileChannel fileChannel = new FileInputStream(
                            new File("temp.tmp")
                    ).getChannel();
                    var intBuffer = fileChannel.map(
                            FileChannel.MapMode.READ_ONLY,0,fileChannel.size()
                    ).asIntBuffer();
                    while (intBuffer.hasRemaining()){
                        intBuffer.get();
                    }
                    fileChannel.close();
                }
            },
            new Tester("Stream write/read") {
                @Override
                public void test() throws IOException {
                    var raf = new RandomAccessFile(new File("temp.tmp"),"rw");
                    raf.writeInt(1);
                    Stream.iterate(0,i -> i++).limit(numOfBuffInts).forEach(i -> {
                        try {
                            raf.seek(raf.length() - 4);
                            raf.writeInt(raf.readInt());
                        }catch (IOException e){
                            throw new RuntimeException(e);
                        }
                    });
                    raf.close();
                }
            },
            new Tester("Mapped WRITE/READ") {
                @Override
                public void test() throws IOException {
                    FileChannel fileChannel = new RandomAccessFile("temp.tmp","rw").getChannel();
                    IntBuffer intBuffer = fileChannel.map(
                            FileChannel.MapMode.READ_WRITE,0,fileChannel.size()
                    ).asIntBuffer();
                    intBuffer.put(0);
                    Stream.iterate(0,i -> i++).limit(numOfBuffInts).forEach(intBuffer::put);
                    fileChannel.close();
                }
            }
    };

    public static void main(String[] args) {
        for (Tester tester : testers) {
            tester.runTest();
        }

    }
}
