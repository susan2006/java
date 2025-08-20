import java.util.ArrayList;
import java.util.*;

public class ArrayListEx1 {
    public static void main(String[] args){
        ArrayList<String> al = new ArrayList<String>();

        al.add("Bear");
        al.add("Lion");
        al.add("Zebra");
        al.add("Cheetah");
        al.add("Deer");

        System.out.println("Elements in arraylist al is: " + al);

        al.add(0,"Rhinoceros");
        System.out.println("\nAfter inserting Rhinoceros at first position: " + al);

        al.remove(4);
        System.out.println("\nAfter removing 5th element: " + al);

        System.out.println("\nElement at 2nd index is: " + al.get(2));

        al.set(3,"Elephant");
        System.out.println("\nUpdated element at 3rd index is: " + al.get(3));

        System.out.println((al.contains("Monkey")) ? "\nMonkey is found." : "\nMonkey is not found.");

        System.out.println((!al.isEmpty()) ? "\nList is empty." : "\nList is not empty.");

        for(String a : al){
            System.out.println(a);
        }

        ArrayList<String>portion = new ArrayList<>(al.subList(1,3));
        System.out.println("Sub list is: " + portion);

        System.out.println("No of elements is: " + al.size());

        Collections.sort(al);
        System.out.println("After sorting array list: " + al);

        Collections.shuffle(al);
        System.out.println("After shuffling array list: " + al);

        Collections.reverse(al);
        System.out.println("After reversing array list: " + al);
    }
}
