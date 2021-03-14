import java.io.*;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.stream.Stream;

public class Ex25 {
    // Method to copy file, replace  allocate()
    // with allocateDirect(), and rename fileDirect:
    public static File toDirect(File f) throws IOException {
        FileChannel fcIn = new FileInputStream(f).getChannel();
        ByteBuffer b = ByteBuffer.allocateDirect((int)f.length());
        fcIn.read(b);
        b.flip();
        Charset cs = Charset.defaultCharset();
        CharBuffer cb = cs.decode(b);
        String cbD1 = cb.toString().replace(
                ".allocate(", ".allocateDirect(");
        String cbD = cbD1.replace(f.getName().split("\\.")[0],
                f.getName().split("\\.")[0] + "Direct");
        CharBuffer cbNew = CharBuffer.wrap(cbD);
        String ext = (f.getName().split("\\."))[1];
        String outFile = (f.getName().split("\\."))[0] +
                "Direct." + ext;
        FileChannel fcOut =
                new FileOutputStream(
                        new File(outFile)).getChannel();
        fcOut.write(cs.encode(cbNew));
        // fcIn.transferTo(0, f.length(), fcOut);
        fcIn.close();
        fcOut.close();
        return new File(outFile);
    }
    // Methods to test performance
    public static void Tester(String s) {
        try { // Uses reflection to call main methods:
            Class c = Class.forName(s);
            String name = c.getSimpleName();
            print("Testing: " + name);
            @SuppressWarnings("unchecked")
            Method m = c.getMethod("main", String[].class);
            // To test ChannelCopy.class
            // (otherwise (String)null OK for second argument):
            String[] sa = new String[]{"ChannelCopy.java", "Test.txt"};
            long startRun = System.nanoTime();
            m.invoke(c.newInstance(), (Object)sa);
            long duration = System.nanoTime() - startRun;
            print("\nTime to run " + name + " = "
                    + duration + " nanoseconds");
        } catch(Exception e) {
            e.printStackTrace(System.err);
        }
    }

    private static void print(String s) {
        System.out.println(s);
    }

    public static long allocationTime(int i) {
        long start = System.nanoTime();
        ByteBuffer bb = ByteBuffer.allocate(i);
        return System.nanoTime() - start;
    }
    public static long directAllocationTime(int i) {
        long start = System.nanoTime();
        ByteBuffer bb = ByteBuffer.allocateDirect(i);
        return System.nanoTime() - start;
    }

    public static void main(final String[] args) throws IOException {
        // allocation time related to statup time:
        print("Time to allocate 1024 bytes = "
                + allocationTime(1024) + " nanoseconds");
        print("Time to allocateDirect 1024 bytes = "
                + directAllocationTime(1024) + " nanoseconds");
        print("Time to allocate 48 bytes = "
                + allocationTime(48) + " nanoseconds");
        print("Time to allocateDirect 48 bytes = "
                + directAllocationTime(48) + " nanoseconds");
        print("Time to allocate 1 byte = "
                + allocationTime(1) + " nanoseconds");
        print("Time to allocateDirect 1 byte = "
                + directAllocationTime(1) + " nanoseconds");
        Tester("GetChannel");
        toDirect(new File("GetChannel.java"));
        // after compiling GetChannelDirect:
        Tester("GetChannelDirect");
        Tester("BufferToText");
        toDirect(new File("BufferToText.java"));
        // after compiling BufferToText.java:
        Tester("BufferToTextDirect");
        Tester("ChannelCopy");
        toDirect(new File("ChannelCopy.java"));
        // after compiling ChannelCopyDirect.java:
        Tester("ChannelCopyDirect");
        Tester("GetData");
        toDirect(new File("GetData.java"));
        // after compiling GetDataDirect.java:
        Tester("GetDataDirect");
        Tester("IntBufferDemo");
        toDirect(new File("IntBufferDemo.java"));
        // after compiling IntBufferDemoDirect.java:
        Tester("IntBufferDemoDirect");
        Tester("UsingBuffers");
        toDirect(new File("UsingBuffers.java"));
        // after compiling UsingBuffersDirect.java:
        Tester("UsingBuffersDirect");
    }
}
