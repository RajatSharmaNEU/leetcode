package GFG.String.Concepts;

public class StringImmutable {
    public static void main(String[] args) {
        String s1 = "Rajat";
        String s2 = s1;
        s1 = s1 + "Sharma";

        System.out.println("is s1 equals to s2 ? " + (s1 == s2));
    }
}
