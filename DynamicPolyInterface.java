interface Animal {
    void makeSound();
}
class Dog implements Animal {
    public void makeSound() {
        System.out.println("Dog : Woof");
    }
}
class Cat implements Animal {
    public void makeSound() {
        System.out.println("Cat : Meow");
    }
}
class Lion implements Animal {
    public void makeSound() {
        System.out.println("Lion : Roar");
    }
}
public class DynamicPolyInterface {
    public static void main(String[] args) {
        Animal a;
        a = new Dog();
        a.makeSound();
        a = new Cat();
        a.makeSound();
        a = new Lion();
        a.makeSound();
    }
}