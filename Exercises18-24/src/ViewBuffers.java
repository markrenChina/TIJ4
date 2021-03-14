import java.nio.*;

public class ViewBuffers {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(
                new byte[]{0,0,0,0,0,0,0,'a'}
        );
        //Rewinds this buffer. The position is set to zero and the mark is discarded.
        byteBuffer.rewind();
        System.out.print("Byte Buffer ");
        while (byteBuffer.hasRemaining()){
            System.out.print(byteBuffer.position() + " -> " + byteBuffer.get() + ", ");
        }
        System.out.println();
        //*************************************
        byteBuffer.rewind();
        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        System.out.print("Char Buffer " );
        while (charBuffer.hasRemaining()){
            System.out.print(charBuffer.position() + " -> " + charBuffer.get() + ", ");
        }
        System.out.println();
        //*************************************
        byteBuffer.rewind();
        FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
        System.out.print("float Buffer " );
        while (floatBuffer.hasRemaining()){
            System.out.print(floatBuffer.position() + " -> " + floatBuffer.get() + ", ");
        }
        System.out.println();
        //*************************************
        byteBuffer.rewind();
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        System.out.print("int Buffer " );
        while (intBuffer.hasRemaining()){
            System.out.print(intBuffer.position() + " -> " + intBuffer.get() + ", ");
        }
        System.out.println();
        //*************************************
        byteBuffer.rewind();
        LongBuffer longBuffer = byteBuffer.asLongBuffer();
        System.out.print("long Buffer " );
        while (longBuffer.hasRemaining()){
            System.out.print(longBuffer.position() + " -> " + longBuffer.get() + ", ");
        }
        System.out.println();
        //*************************************
        byteBuffer.rewind();
        ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
        System.out.print("short Buffer " );
        while (shortBuffer.hasRemaining()){
            System.out.print(shortBuffer.position() + " -> " + shortBuffer.get() + ", ");
        }
        System.out.println();
        //*************************************
        byteBuffer.rewind();
        DoubleBuffer doubleBuffer = byteBuffer.asDoubleBuffer();
        System.out.print("double Buffer " );
        while (doubleBuffer.hasRemaining()){
            System.out.print(doubleBuffer.position() + " -> " + doubleBuffer.get() + ", ");
        }
        System.out.println();
    }
}
