package GFG.String;

public class FindExcelColumnName {
    // Or you can simply take a string and perform this logic ,no issue i found in here.
    static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    static String num_hash(int num) {
        if (num <= 26)
            return Character.toString(alpha.charAt(num - 1));
        else {
            int q = Math.floorDiv(num, 26);
            int r = num % 26;
            if (r == 0) {
                return num_hash(q - 1) + alpha.charAt((26 + r - 1) % 26);
            } else
                return num_hash(q) + alpha.charAt((26 + r - 1) % 26);
        }
    }

    public static void main(String[] args) {

        System.out.println(num_hash(1));
        System.out.println(num_hash(26));
        System.out.println(num_hash(27));
        System.out.println(num_hash(52));
        System.out.println(num_hash(80));
        System.out.println(num_hash(676));
        System.out.println(num_hash(702));
        System.out.println(num_hash(705));

    }
}
