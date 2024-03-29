public class InnerThread2 {

    private int countDown = 5;
    private Thread t;

    public InnerThread2(String name){
        t = new Thread(name){
            @Override
            public void run() {
                while (true){
                    System.out.println(this);
                    if (--countDown == 0){
                        return;
                    }
                }
            }

            @Override
            public String toString() {
                return "#" + getName() +"(" + countDown + "),";
            }
        };

        t.start();
    }
}
