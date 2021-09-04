package greenHouse;

import java.util.*;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static net.mindview.util.Print.print;

/**
 * 实际代码不要使用这么继承实现
 */
public class Ex23 {
    private volatile boolean light = false;
    private volatile boolean water = false;
    private String thermostat = "Day";

    public synchronized String getThermostat() {
        return thermostat;
    }

    public synchronized void setThermostat(String value) {
        thermostat = value;
    }

    //ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(10);
    DelayQueue<Task> queue = new DelayQueue<Task>();

    public void schedule(Task event) {
        queue.add(event);
    }

    public void repeat(Task event) {
        queue.put(event);
    }

    class Task implements Runnable,Delayed {

        private int delta;
        private long trigger;
        private int repeatDelta = -1;

        public Task(int deltaMilliseconds) {
            this.delta = deltaMilliseconds;
            //换算成到期，方便比较
            this.trigger = System.nanoTime() + NANOSECONDS.convert(delta,MILLISECONDS);
        }

        public Task(int delta, int repeatDelta) {
            this(delta);
            this.repeatDelta = repeatDelta;
        }

        @Override
        public int compareTo(Delayed o) {
            Task that = (Task) o;
            if (trigger < that.trigger) { return -1; }
            if (trigger > that.trigger) { return 1; }
            return 0;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(trigger - System.nanoTime(),NANOSECONDS);
        }

        @Override
        public void run() {
            if (repeatDelta != -1) {
                this.delta = repeatDelta;
                this.trigger = System.nanoTime() + NANOSECONDS.convert(delta,MILLISECONDS);
                queue.put(this);
            }
        }
    }

    class LightOn extends Task{

        public LightOn(int deltaMilliseconds) {
            super(deltaMilliseconds);
        }

        public LightOn(int delta, int repeatDelta) {
            super(delta, repeatDelta);
        }

        @Override
        public void run() {
            //Put hardware control code here to
            //physically turn on the light
            System.out.println("Turning on lights");
            light = true;
            super.run();
        }
    }

    class LightOff extends Task {

        public LightOff(int deltaMilliseconds) {
            super(deltaMilliseconds);
        }

        public LightOff(int delta, int repeatDelta) {
            super(delta, repeatDelta);
        }

        @Override
        public void run() {
            //Put hardware control code here to
            // physically turn off the light
            System.out.println("Turning off lights");
            light = false;
            super.run();
        }
    }

    class WaterOn extends Task {

        public WaterOn(int deltaMilliseconds) {
            super(deltaMilliseconds);
        }

        public WaterOn(int delta, int repeatDelta) {
            super(delta, repeatDelta);
        }

        @Override
        public void run() {
            //Put hardware control code here
            System.out.println("Turning greenhouse water on");
            water = true;
            super.run();
        }
    }

    class WaterOff extends Task {

        public WaterOff(int deltaMilliseconds) {
            super(deltaMilliseconds);
        }

        public WaterOff(int delta, int repeatDelta) {
            super(delta, repeatDelta);
        }

        @Override
        public void run() {
            //Put hardware control code here
            System.out.println("Turning greenhouse water off");
            water = false;
            super.run();
        }
    }

    class ThermostatNight extends Task {

        public ThermostatNight(int deltaMilliseconds) {
            super(deltaMilliseconds);
        }

        public ThermostatNight(int delta, int repeatDelta) {
            super(delta, repeatDelta);
        }

        @Override
        public void run() {
            //Put hardware control code here
            System.out.println("Thermostat to night setting");
            setThermostat("Night");
            super.run();
        }
    }

    class ThermostatDay extends Task{

        public ThermostatDay(int deltaMilliseconds) {
            super(deltaMilliseconds);
        }

        public ThermostatDay(int delta, int repeatDelta) {
            super(delta, repeatDelta);
        }

        @Override
        public void run() {
            //Put hardware control code here
            System.out.println("Thermostat to day setting");
            setThermostat("Day");
            super.run();
        }
    }

    class Bell extends Task {

        public Bell(int deltaMilliseconds) {
            super(deltaMilliseconds);
        }

        public Bell(int delta, int repeatDelta) {
            super(delta, repeatDelta);
        }

        @Override
        public void run() {
            System.out.println("Bing!");
            super.run();
        }
    }

    class Terminate extends Task {

        private ExecutorService exec;

        public Terminate(int deltaMilliseconds,ExecutorService e) {
            super(deltaMilliseconds);
            exec = e;
        }

        @Override
        public void run() {
            System.out.println("Terminating");
            exec.shutdownNow();
            //Must start a separate task to do this job
            //since the scheduler has been shut down
            new Thread() {
                @Override
                public void run() {
                    for (DataPoint datum : data) {
                        System.out.println(datum);
                    }
                }
            }.start();
        }
    }

    //New feature : data collection
    static class DataPoint {
        final Calendar time;
        final float temperature;
        final float humidity;

        public DataPoint(Calendar time, float temperature, float humidity) {
            this.time = time;
            this.temperature = temperature;
            this.humidity = humidity;
        }

        @Override
        public String toString() {
            return time.getTime() + String.format("temperature %1$.1f humidity: %2$.2f" ,temperature, humidity);
        }
    }

    private Calendar lastTime = Calendar.getInstance();
    {
        //Adjust date to the half hour
        lastTime.set(Calendar.MINUTE,30);
        lastTime.set(Calendar.SECOND,00);
    }

    private float lastTemp = 65.0f;
    private int tempDirection = +1;
    private float lastHumidity = 50.0f;
    private int humidityDirection = +1;
    private Random rand = new Random(47);
    List<DataPoint> data = Collections.synchronizedList(
            new ArrayList<DataPoint>()
    );

    class CollectData extends Task{

        public CollectData(int deltaMilliseconds) {
            super(deltaMilliseconds);
        }

        public CollectData(int delta, int repeatDelta) {
            super(delta, repeatDelta);
        }

        @Override
        public void run() {
            System.out.println("Collecting data");
            synchronized (Ex23.this){
                //Pretend the interval is longer than it is
                lastTime.set(Calendar.MINUTE,lastTime.get(Calendar.MINUTE) + 30);
                //One in 5 chances of reversing the direction
                if (rand.nextInt(5) == 4) {
                    tempDirection = -tempDirection;
                }
                //Store previous value:
                lastTemp = lastTemp + tempDirection * (1.0f + rand.nextFloat());
                if (rand.nextInt(5) == 4) {
                    humidityDirection = - humidityDirection;
                }
                lastHumidity = lastHumidity + humidityDirection * rand.nextFloat();
                //Calendar must be cloned, otherwise all
                //DataPoints hold references to the same lastTime
                //For a basic object like Calendar,clone() is OK
                data.add(new DataPoint((Calendar) lastTime.clone(),lastTemp,lastHumidity));
            }
            super.run();
        }
    }

    public static void main(String[] args) {
        Ex23 gh = new Ex23();
        ExecutorService exec = Executors.newCachedThreadPool();
        gh.schedule(gh.new Terminate(5000,exec));
        //Former "Restart" class not necessary
        gh.repeat(gh.new Bell(0,1000));
        gh.repeat(gh.new ThermostatNight(0,2000));
        gh.repeat(gh.new LightOn(0 , 2000) );
        gh.repeat(gh.new LightOff(0, 400));
        gh.repeat(gh.new WaterOn(0,600));
        gh.repeat(gh.new WaterOff(0,800));
        gh.repeat(gh.new ThermostatDay(0 ,1400) );
        gh.repeat(gh.new CollectData(500,500));
        exec.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!Thread.interrupted()){
                        gh.queue.take().run();
                    }
                }catch (InterruptedException e){
                    //exit
                }
                print("Finished Ex23");
            }
        });
    }
}
