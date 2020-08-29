package com.TIJ4.Ex3.util;
import static com.TIJ4.Ex3.util.Print.*;
public class Dogs {

	public static void main(String[] args) {
		Dog spot=new Dog();
		Dog scruffy=new Dog();
		spot.name="spot";
		spot.say="Ruff!";
		scruffy.name="scruffy";
		scruffy.say="Wurf!";
		print(spot.name+spot.say);
		print(scruffy.name+scruffy.say);
		Dog newDog =new Dog();
		newDog=spot;
		print(spot==newDog);
		print(spot.equals(newDog));
		newDog.say="Wurf!";
		print(spot==newDog);
		print(spot.equals(newDog));
		print(spot.name+spot.say);
	}

}
class Dog{
	String name,say;
	
}