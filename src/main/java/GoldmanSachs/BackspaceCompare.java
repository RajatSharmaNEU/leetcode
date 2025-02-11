package GoldmanSachs;

public class BackspaceCompare {
    public static boolean backspaceCompare(String s, String t) {
        // helper
        // new string generate if # and string length != 0 remove last element

        return generateString(s).equals(generateString(t));
    }

    public static String generateString(String s) {
        StringBuilder str = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '#') {
                int l = str.length();
                if (l != 0) {
                    str.delete(l - 1, l);
                }

            } else {
                str.append(c);
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        System.out.println(backspaceCompare(s, t));
    }
}
