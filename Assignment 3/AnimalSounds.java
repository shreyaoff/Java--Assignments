// Question 3: Animal Sound System
// Create a base class Animal with method makeSound().
// Subclasses: Dog, Cat, Cow override makeSound() to print specific animal sounds.
// Store different animals in an array and use polymorphism to call makeSound() on each.

class Animal {
    void makeSound() {
        System.out.println("Some animal makes a sound...");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog says: Woof! Woof!");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Cat says: Meow! Meow!");
    }
}

class Cow extends Animal {
    @Override
    void makeSound() {
        System.out.println("Cow says: Moo! Moo!");
    }
}

public class AnimalSounds {
    public static void main(String[] args) {
        Animal[] animals = {
            new Dog(),
            new Cat(),
            new Cow(),
            new Dog()
        };

        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}
