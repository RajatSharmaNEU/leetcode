package GFG.String;

public class CheckSubsequence {
    private boolean isSubsequence(String s1, String s2) {
        if (s1.length() == 0 && s2.length() == 0) {
            return false;
        }

        if (s1.length() == 0 || s2.length() == 0) {
            return false;
        }

        if (s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1)) {
            return isSubsequence(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1));
        } else {
            return isSubsequence(s1.substring(0, s1.length() - 1), s2);
        }
    }

    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "AD";

//        String s1 = "ABCDE";
//        String s2 = "AED";


        CheckSubsequence checkSubsequence = new CheckSubsequence();
        System.out.println(checkSubsequence.isSubsequence(s1, s2));
    }
}
