import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class LockingMappedFiles {

    private static final int LENGTH = 0x8FFFFFF;
    static FileChannel fc;
    public static void main(String[] args) throws IOException {
        fc = new RandomAccessFile("test.dat","rw").getChannel();
        MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE,0,LENGTH);
        for (int i = 0 ; i < LENGTH; i ++) {
            out.put((byte) 'x');
        }
        new LockAndModify(out,0, LENGTH / 3);
        new LockAndModify(out,LENGTH/2 , LENGTH/2 + LENGTH/4);
    }

    private static class LockAndModify extends Thread {
        private ByteBuffer byteBuffer;
        private int start,end;
        LockAndModify(ByteBuffer mbb, int start, int end) {
            this.start = start;
            this.end = end;
            mbb.limit(end);
            mbb.position(start);
            byteBuffer = mbb.slice();
            start();
        }

        @Override
        public void run() {
            //Exclusive lock with no overlap
            try {
                FileLock fl = fc.lock(start,end,false);
                System.out.println("Locked: " + start + " to " + end);
                //Perform modification
                while (byteBuffer.position() < byteBuffer.limit() - 1) {
                    byteBuffer.put((byte) (byteBuffer.get() - 1));
                }
                fl.release();
                System.out.println("Released: " + start + " to " + end);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
