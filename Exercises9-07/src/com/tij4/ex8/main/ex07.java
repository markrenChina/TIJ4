package com.tij4.ex8.main;
import polymorphism.music.Note;
import static com.tij4.util.Print.*;



class Mouse implements Rodent {
	@Override
	public
  void eat() {print("Mouse eat");}
}	

class Gerbil implements Rodent {
	@Override
	public
  void eat() {print("Gerbil eat");}
}

class Hamster implements Rodent {
	@Override
	public void eat() {print("Hamster eat");}
}

public class ex07 {	
  public static void main(String[] args) {
    // Upcasting during addition to the array:
    Rodent[] orchestra = {
      new Mouse(),
      new Gerbil(),
      new Hamster(),
    };
    for(Rodent i:orchestra)
    	i.eat();
    	// print(i.toString());
    
  }
} /* Output:
Wind.play() MIDDLE_C
Percussion.play() MIDDLE_C
Stringed.play() MIDDLE_C
Brass.play() MIDDLE_C
Woodwind.play() MIDDLE_C
*///:~