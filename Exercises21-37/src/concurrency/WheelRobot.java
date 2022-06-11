package concurrency;

public class WheelRobot extends Robot{
    public WheelRobot(RobotPool p) {
        super(p);
    }

    @Override
    protected void performService() {
        System.out.println(this + " installing Wheels");
        assembler.getCar().addWheels();
    }
}
