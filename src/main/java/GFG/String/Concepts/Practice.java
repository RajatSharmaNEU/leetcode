package GFG.String.Concepts;

public class Practice {
    public static String generateColumnRecursion(int columnNumber) {
        String columns = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (columnNumber <= 26) {
            return "" + columns.charAt(columnNumber - 1);
        }

        int q = columnNumber / 26;
        int r = columnNumber % 26;

        return generateColumnRecursion(q) + columns.charAt(r - 1);
    }

    public static String generateColumn(int columnNumber) {
        String columns = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (columnNumber <= 26) {
            return "" + columns.charAt(columnNumber - 1);
        }

        StringBuilder result = new StringBuilder();
        do {
            int r = columnNumber % 26;
            result = result.append(columns.charAt(r - 1));
            columnNumber = columnNumber / 26;
        } while (columnNumber > 0);

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(generateColumnRecursion(1));
        System.out.println(generateColumnRecursion(26));
        System.out.println(generateColumnRecursion(27));
        System.out.println(generateColumnRecursion(998));


        System.out.println(generateColumn(1));
        System.out.println(generateColumn(26));
        System.out.println(generateColumn(27));
        System.out.println(generateColumn(998));
    }
}
