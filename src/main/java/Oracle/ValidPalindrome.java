package Oracle;

public class ValidPalindrome {
    public static boolean isValidAlphanumeric(Character c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    public static boolean isPalindrome(String s) {
        int low = 0, high = s.length() - 1;

        while (low <= high) {
            char lowChar = s.charAt(low);
            char highChar = s.charAt(high);

            if (!isValidAlphanumeric(lowChar)) {
                low++;
            } else if (!isValidAlphanumeric(highChar)) {
                high--;
            } else if (Character.toLowerCase(lowChar) != Character.toLowerCase(highChar)) {
                return false;
            } else {
                low++;
                high--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
