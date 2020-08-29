package com.tij4.ex10.main;


public class GreenhouseController {
	public static void main(String[] args) {
		GreenhouseControls gc=new GreenhouseControls();
		waterMist gc2=new waterMist();
		gc.addEvent(gc.new Bell(900));
		Event[] eventlist= {
				gc.new ThermostatNight(0),
				gc.new LightOn(200),
				gc.new LightOff(400),
				gc.new WaterOn(600),
				gc2.new waterMistOn(650),
				gc.new FanOn(700),
				gc.new WaterOff(800),
				gc2.new waterMistOff(850),
				gc.new FanOff(900),
				gc.new ThermostatDay(1400)
		};
		gc.addEvent(gc.new Restart(2000,eventlist));
		if(args.length==1)
			gc.addEvent(new GreenhouseControls.Terminate(new Integer(args[0])));
		gc.run();
	}
}