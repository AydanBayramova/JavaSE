package String;

public class StringMethods {
    public static void main(String[] args) {

        String s = "Java";
        System.out.println(s.length());

        String s1 = "Aydan";
        System.out.println(s1.charAt(0));
        System.out.println(s1.charAt(4));

        String s2 = "Programming";
        System.out.println(s2.substring(3));
        System.out.println(s2.substring(0, 6));

        String a = "Java";
        System.out.println(a.toLowerCase());

        String a1 = "Hello";
        String b = "hello";
        System.out.println(a1.equalsIgnoreCase(b));

        String  s5 = "I love C#";
        System.out.println(s5.replace("C#", "Java"));

        String s6 = "apple,banana,orange";
        System.out.println(s6.split(","));

        String s7 = "Hello ";
        String s8 = "World";
        System.out.println(s7.concat(s8));

        String s9 = "banana";
        System.out.println(s9.indexOf("a"));
        System.out.println(s9.lastIndexOf("a"));

        String s10 = "   hello world   ";
        System.out.println(s10.trim());
    }
}
