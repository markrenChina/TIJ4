package ex7;

//Examination of the way the class loader works

class Candy {
    static {
        System.out.println("Loading Candy");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }
}

class Cookie{
    static {
        System.out.println("Loading Cookie");
    }
}

public class SweetShop {

    public static void main(String[] args) {
        try {
            if (args.length == 3){
                if (!"java".equals(args[0] )){
                    return;
                }
            }else {
                return;
            }
            //Class clz = Class.forName("ex7."+args[1]+ "."+args[2]);
            Class clz = Class.forName("ex7."+args[2]);
            Object obj = clz.newInstance();
        }catch (ClassNotFoundException | InstantiationException | IllegalAccessException e){
            System.out.println("Couldn't find Gum");
        }

    }
}
