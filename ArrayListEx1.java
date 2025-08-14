import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class ArrayListEx1 {
    public static void main(String[] args){
        ArrayList<String> al = new ArrayList<String>();
        //System.out.println("Size of arraylist al is: " + al.size());
        int flag = 0;

        al.add("Bear");
        al.add("Lion");
        al.add("Zebra");
        al.add("Cheetah");
        al.add("Leopard");
        al.add("Deer");
        al.add("Gorilla");
        al.add("Giraffe");

        System.out.println("Elements in arraylist al is: " + al);

        al.add(1,"Rhinoceros");
        System.out.println("\nAfter inserting Rhinoceros at first position: ");
        for(String s : al){
            System.out.println(s);
        }

        al.remove(5);
        System.out.println("\nAfter removing 5th element: ");
        for(String s : al){
            System.out.println(s);
        }

        String someElement = al.get(2);
        System.out.println("\nElement at 2nd index is: " + someElement);

        al.set(5,"Elephant");
        System.out.println("\nUpdated element at 5th index is: " + al.get(5));

        /*
        for(String s : al){
            if(s == "Monkey"){
                System.out.println("Monkey is found.");
            }
            else{
                System.out.println("Monkey is not found.");
            }
        }
        */

        System.out.println((al.contains("Monkey")) ? "\nMonkey is found." : "\nMonkey is not found.");

        if(!al.isEmpty()){
            System.out.println("\nArray list is not empty.");
        }
        else{
            System.out.println("\nArray list is empty.");
        }

        ArrayList<Integer> ial = new ArrayList<> ();
        ial.add(59);
        ial.add(46);
        ial.add(19);
        ial.add(72);
        ial.add(5);
        System.out.println("Before sorting array list: " + ial);
        Collections.sort(ial);
        System.out.println("After sorting array list: " + ial);

        Collections.shuffle(ial);
        System.out.println("After shuffling array list: " + ial);

        Collections.reverse(ial);
        System.out.println("After reversing array list: " + ial);
    }
}
