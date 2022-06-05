public class PostOffice {
        static void handle(Mail m){
        for (MailHandler mailHandler : MailHandler.values()) {
            if (mailHandler.handle(m)) {
                return;
            }
        }
        System.out.println(m + " is a dead letter");
    };

    public static void main(String[] args) {
        Mail.generator(10).forEach(mail -> {
            System.out.println(mail.details());
            handle(mail);
            System.out.println("**************");
        });
    }

//mailHandle 负责实现责任链
    enum MailHandler {
        GENERAL_DELIVERY {
            @Override
            boolean handle(Mail m) {
                if (m.generalDelivery == Mail.GeneralDelivery.YES) {
                    System.out.println("Using general delivery for " + m);
                    return true;
                }
                return false;
            }
        },
        MACHINE_SCAN {
            @Override
            boolean handle(Mail m) {
                switch (m.scannability) {
                    case UNSCANNABLE: return false;
                    default:
                        switch (m.address) {
                            case INCORRECT:return false;
                            default:
                                System.out.println("Delivering " + m + " automatically");
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION {
            @Override
            boolean handle(Mail m) {
                switch (m.readability) {
                    case ILLEGIBLE:return false;
                    default:
                        switch (m.address) {
                            case INCORRECT:return false;
                            default:
                                System.out.println("Delivering " + m + " normally");
                                return true;
                        }
                }
            }
        },
        RETURN_TO_SENDER {
            @Override
            boolean handle(Mail m) {
                switch (m.returnAddress) {
                    case MISSING: return false;
                    default:
                        System.out.println("Returning "+ m + " to sender");
                        return true;
                }
            }
        };
        abstract boolean handle(Mail m);
    }
}
