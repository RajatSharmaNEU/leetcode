package GFG.String.Concepts;

public class StringMethods {
    public static void main(String[] args) {
        System.out.println("---String Primitive---");
        String s1 = "Rajat Sharma";
        String s2 = "Rajat Sharma";

        if(s1 == s2) {
            System.out.println("Yes, s1, s2, and string variable points to same string reference");
        } else {
            System.out.println("No");
        }

        String stringObj = new String("Rajat Sharma");
        if(s1 == stringObj) {
            System.out.println("Yes, s1, s2, and string variable points to same string reference");
        } else {
            System.out.println("No, new String() will create new reference for string");
        }


        System.out.println("---String Methods---");

        String string = "Rajat Sharma";
        System.out.println(string.length());
        System.out.println(string.charAt(3));
        System.out.println(string.substring(6));
        System.out.println(string.substring(0, 4));

    }
}
