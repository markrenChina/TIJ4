package ex;

import java.util.EnumMap;
import java.util.Map;

interface Handler { abstract boolean handle(Mail m); } // Command design pattern

public class ex09 {
    public static void handle(Mail m, EnumMap<MailHandler,Handler> em) {
        for(Map.Entry<MailHandler,Handler> e : em.entrySet()) {
            if(e.getValue().handle(m)) return;
        }
        System.out.println(m + " is a dead letter");
    }

    public static void main(String[] args) {
        EnumMap<MailHandler,Handler> em = new EnumMap<MailHandler,Handler>(MailHandler.class);
        em.put(MailHandler.GENERAL_DELIVERY, new Handler() {
            public boolean handle(Mail m) {
                switch(m.generalDelivery) {
                    case YES:
                        System.out.println("Using general delivery for " + m);
                        return true;
                    default: return false;
                }
            }
        });
        em.put(MailHandler.MACHINE_SCAN, new Handler() {
            public boolean handle(Mail m) {
                switch(m.scannability) {
                    case UNSCANNABLE: return false;
                    default:
                        switch(m.address) {
                            case INCORRECT: return false;
                            default:
                                System.out.println("Delivering " + m + " automatically");
                                return true;
                        }
                }
            }
        });
        em.put(MailHandler.VISUAL_INSPECTION, new Handler() {
            public boolean handle(Mail m) {
                switch(m.readability) {
                    case ILLEGIBLE: return false;
                    default:
                        switch(m.address) {
                            case INCORRECT: return false;
                            default:
                                System.out.println("Delivering " + m + " normally");
                                return true;
                        }
                }
            }
        });
        em.put(MailHandler.RETURN_TO_SENDER, new Handler() {
            public boolean handle(Mail m) {
                switch(m.returnAddress) {
                    case MISSING: return false;
                    default:
                        System.out.println("Return " + m + " to sender");
                        return true;
                }
            }
        });
        for(Mail mail : Mail.generator(10)) {
            System.out.println(mail.details());
            handle(mail, em);
            System.out.println("*****");
        }
    }
    enum MailHandler { GENERAL_DELIVERY, MACHINE_SCAN, VISUAL_INSPECTION, RETURN_TO_SENDER }
}
