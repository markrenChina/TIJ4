package ex26;

class Instrument {
}

class Percussion extends  Instrument {

}

class Stringed extends Instrument {

}

class Wind extends Instrument {
    void clearSpitValue(){
        System.out.println("clearSpitValue");
    };
}

public class Ex26 {

    public static void main(String[] args) {
        Instrument wind = new Wind();
        if (wind instanceof Wind){
            ((Wind) wind).clearSpitValue();
        }
    }
}
