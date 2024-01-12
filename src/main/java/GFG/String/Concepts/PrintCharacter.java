package GFG.String.Concepts;

public class PrintCharacter {
    public static void main(String[] args) {
        int a = 97; // to 123
        int A = 65; // to 91

        int j = 26;
        while(j-- > 0) {
            System.out.print((char) A++);
        }

        System.out.println();
        j = 26;
        while(j-- > 0) {
            System.out.print((char) a++);
        }

//        System.out.println((char)122);
//        System.out.println((char)90);
    }
}
