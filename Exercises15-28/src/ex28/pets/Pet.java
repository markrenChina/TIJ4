//: typeinfo/pets/Pet.java
package ex28.pets;

public class Pet  {
  String name;
  public Pet(String name) { this.name = name;}

  @Override
  public String toString() {
    return "Pet{" +
            "name='" + name + '\'' +
            '}';
  }
} ///:~
