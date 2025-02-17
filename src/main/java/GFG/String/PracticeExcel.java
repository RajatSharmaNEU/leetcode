package GFG.String;

public class PracticeExcel {
    private static String printExcelColumn(int column) {


        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


        if(column <= 26) {
            return Character.toString(alphabets.charAt(column - 1));
        } else {
            int quotient = Math.floorDiv(column,  26);
            int remainder = column % 26;

            if(remainder == 0) {
                return printExcelColumn(quotient - 1) + alphabets.charAt((26 + remainder - 1) % 26);
            } else {
                return printExcelColumn(quotient) + alphabets.charAt((26 + remainder - 1) % 26);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(printExcelColumn(1));
        System.out.println(printExcelColumn(26));
        System.out.println(printExcelColumn(52));
        System.out.println(printExcelColumn(80));
        System.out.println(printExcelColumn(676));
        System.out.println(printExcelColumn(702));
        System.out.println(printExcelColumn(705));
    }
}
