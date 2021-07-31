public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    //ex13 add synchronized
    public static synchronized int nextSerialNumber(){
        /**
         * if in c++ is Thread-safe
         * if in java not Thread-safe
         */
        return serialNumber++;
    }
}
