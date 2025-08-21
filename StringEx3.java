public class StringEx3 {
    public static void main(String[] args){
        String str1 = "melon";
        String str2 = "Melon";
        String str3 = str2;

        System.out.println(str1.equals(str2));
        System.out.println(str2.equals(str3));
        System.out.println(str1.compareTo(str2));
        System.out.println(str1 == str3);
    }
}
