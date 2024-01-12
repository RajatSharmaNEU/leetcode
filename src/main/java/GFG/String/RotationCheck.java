package GFG.String;

public class RotationCheck {
    private boolean isRotationalEqual(String s1, String s2) {
        return (s1 + s1).indexOf(s2) >= 0;
    }

    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "CDAB";

        String s3 = "ABAB";
        String s4 = "ABBA";
        RotationCheck rotationCheck = new RotationCheck();
        System.out.println(rotationCheck.isRotationalEqual(s1, s2));
        System.out.println(rotationCheck.isRotationalEqual(s3, s4));
    }
}
