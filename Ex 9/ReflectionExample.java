import java.lang.Class;
import java.lang.reflect.*;
import java.util.ArrayList;

interface Intersample{
    void hello();
}

class ClassSample implements Intersample{
    private String str;

    public ClassSample(){
        System.out.println("Constructor of ClassSample.");
    }

    public void hello(){
        System.out.println("Hello, it's ClassSample.");
    }
    private void bye(){
        System.out.println("Bye, " + str);
    }
    public void greeting(String s){
        System.out.println("Good Morning, " + s);
    }

}

public class ReflectionExample {
    public static void main(String[] args) throws Exception{
        ClassSample cs = new ClassSample();
        Class<?> cls = Class.forName("ClassSample");

        System.out.println("Is ClassSample interface: " + cls.isInterface());
        System.out.println("Super class of ClassSample is: " + cls.getSuperclass().getName());

        Method[] m1 = cls.getMethods();
        System.out.println("All public methods: ");
        for(int i = 0; i < m1.length; i++){
            System.out.println(m1[i].getName());
        }

        Method[] m2 = cls.getDeclaredMethods();
        System.out.println("All declared methods: ");
        for(Method method : m2){
            System.out.println(method.getName());
        }

        Method mgreeting = cls.getDeclaredMethod("greeting",String.class);
        mgreeting.invoke(cs, "XXXX");

        Field f1 = cls.getDeclaredField("str");
        f1.setAccessible(true);
        f1.set(cs,"XXXX");

        Method mbye = cls.getDeclaredMethod("bye");
        mbye.setAccessible(true);
        mbye.invoke(cs);

        Class<?> arraycls = ArrayList.class;
        Constructor<?> cons = arraycls.getConstructor();
        System.out.println("The name of constructor is: " + cons.getName());
        
        Method[] methods = arraycls.getDeclaredMethods();
        System.out.println("The methods in arraylist collections are: ");
        for(Method m : methods){
            System.out.println(m.getName());
        }

    }
}
