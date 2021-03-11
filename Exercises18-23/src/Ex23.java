import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class Ex23 {

    /*public static void main(String[] args) {
        ByteBuffer buff = ByteBuffer.allocate(24); //more than needed
        buff.asCharBuffer().put("third text,third text,third text");

    }*/

    public static boolean isPrintable(char c) {
        // Check char in printable range:
        return ((c >= '!') && (c <= '~'));
    }

    public static void printCharBuffer(CharBuffer cb) {
        cb.clear(); // Sets position to zero, limit to capacity
        while (cb.hasRemaining()) {
            char c = cb.get();
            if (isPrintable(c)) System.out.print(c);
        }
    }

    public static void main(String[] args) throws Exception {
        char[] ca = {'w', 'x', 'y', 'z'};
        CharBuffer cb = CharBuffer.wrap(ca);
        System.out.print("CharBuffer by wrapping char[]: ");
        printCharBuffer(cb);
        System.out.println();
        CharBuffer cb2 = CharBuffer.allocate(6);
        char[] ca2 = {'s', 't', 'u', 'v', 'w'};
        cb2.put(ca2);
        System.out.print("CharBuffer by allocation: ");
        printCharBuffer(cb2);
        System.out.println();
        // Try some unprintable chars:
        char[] ca3 = {(char) 0x01, (char) 0x07, (char) 0x7F, 'b', 'y', 'e'};
        CharBuffer cb3 = CharBuffer.wrap(ca3);
        System.out.print("CharBuffer including some unprintable: ");
        printCharBuffer(cb3);
    }
}
