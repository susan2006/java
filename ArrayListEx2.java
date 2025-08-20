import java.util.*;

class Person{
    String name;
    int age;
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
public class ArrayListEx2 {
    public static void main(String[] args){
        ArrayList<Person>p = new ArrayList<>();
        p.add(new Person("Akash",21));
        p.add(new Person("Rhoshini",24));
        p.add(new Person("Mani",23));
        p.add(new Person("Kala",22));
        System.out.println("Initial list: " + p);

        p.add(0, new Person("Vignesh",20));
        System.out.println("After inserting at first position: " + p);

        p.remove(4);
        System.out.println("After removing at fifth position: " + p);
        System.out.println(!p.isEmpty() ? "List is not empty." : "List is empty.");
        System.out.println("Elemetn at index 2: " + p.get(2));

        Collections.shuffle(p);
        System.out.println("After shuffling: " + p);

        Collections.reverse(p);
        System.out.println("After reversing: " + p);
    }
}
