import java.io.*;

class Person implements Serializable{
    String name;
    int age;

    Person(){
        name = "";
        age = 0;
    }

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}

public class FileEx8 {
    public static void main(String[] args) {
        try {
            Person p1 = new Person("Shalini", 20);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("newobj.txt"));
            oos.writeObject(p1);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("newobj.txt"));
            Person p = (Person)ois.readObject();
            System.out.println("Name: " + p.name + " Age: " + p.age);
            ois.close();
        }
        catch(Exception e){
            System.err.print("Error: " + e.getMessage());
        }
    }
}

