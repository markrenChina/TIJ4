package ex37;

import java.util.Date;

interface TimeStamped { long getStamp(); }

interface SerialNumbered { long getSerialNumber(); }

interface Tag {
    int enums();
    void setEnumsTag(int tag);
}

interface Basic {
    public void set(String val);
    public String get();
}

class TimeStampedImp implements  TimeStamped {
    private final long timeStamp;

    public TimeStampedImp() {
        this.timeStamp = new Date().getTime();
    }

    @Override
    public long getStamp() {
        return timeStamp;
    }
}

class SerialNumberedImp implements  SerialNumbered {
    private static long counter =1;
    private final long serialNumber = counter++;

    @Override
    public long getSerialNumber() {
        return serialNumber;
    }
}

class TagImp implements  Tag {
    private static int enum_tag;

    @Override
    public int enums() {
        return enum_tag;
    }

    @Override
    public void setEnumsTag(int tag) {
        TagImp.enum_tag = tag;
    }

}

class BasicImp implements  Basic {
    private String value;

    @Override
    public void set(String val) {
        value = val;
    }

    @Override
    public String get() {
        return value;
    }
}
class Mixin extends  BasicImp implements  TimeStamped,  SerialNumbered, Tag {
    private  TimeStamped timeStamped = new  TimeStampedImp();
    private  SerialNumbered serialNumber = new  SerialNumberedImp();

    private Tag tag = new TagImp();

    @Override
    public long getStamp() {
        return timeStamped.getStamp();
    }

    @Override
    public long getSerialNumber() {
        return serialNumber.getSerialNumber();
    }

    @Override
    public int enums() {
        return tag.enums();
    }

    @Override
    public void setEnumsTag(int tag) {
        this.tag.setEnumsTag(tag);
    }
}

public class Ex37 {
    public static void main(String[] args) {
         Mixin mixin1 = new  Mixin(),mixin2 = new  Mixin();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        System.out.println(mixin1.get() + " " +
                mixin1.getStamp() + " " + mixin1.getSerialNumber());
        System.out.println(mixin2.get() + " " +
                mixin2.getStamp() + " " + mixin2.getSerialNumber());
    }
}
