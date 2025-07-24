import org.Test.Animal;

public class Kingdom implements Animal {
    @Override
    public void Dog() {
        System.out.println("Dog Barks");
    }

    @Override
    public void Cat() {
        System.out.println("Cat meows");
    }

    @Override
    public void Fox() {
        System.out.println("What does the fox say");
    }

public void Deer(){
    System.out.println("Deer is eating");
}
public static void main(String[] args) {
    Animal a=new Kingdom();
    Kingdom b=new Kingdom();
    a.Cat();
    a.Fox();
    a.Dog();
    b.Deer();

}}