public class Command {

    public Command(String cmd) {
        this.cmd = cmd;
    }

    String cmd;
    public void operation(){
        System.out.println(cmd);
    }
}
