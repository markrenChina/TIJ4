package com.tij4.ex8.main;
import polymorphism.music.Note;
import static com.tij4.util.Print.*;



class Mouse extends Rodent {
	@Override
  void eat() {print("Mouse eat");}
}	

class Gerbil extends Rodent {
	@Override
  void eat() {print("Gerbil eat");}
}

class Hamster extends Rodent {
	@Override
  void eat() {print("Hamster eat");}
}

public class Rodent {
  void eat() { }	
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