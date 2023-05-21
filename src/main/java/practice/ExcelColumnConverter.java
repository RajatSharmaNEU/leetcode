package practice;

public class ExcelColumnConverter {
    public static String getColumnName(int columnNumber) {
        // Step1 - Find remainder & quotient with divisor as 26
        // Step2 - A + remainder for Column name
        // Step3 - Update ColumnNumber = quotient
        // Step4 - reverse string

        StringBuilder columnName = new StringBuilder();

        while(columnNumber > 0) {
            int remainder = (columnNumber - 1) % 26;
            int quotient = (columnNumber - 1) / 26;
            columnName.append((char)('A' + remainder));
            columnNumber = quotient;
        }

        return columnName.reverse().toString();
    }

    public static void main(String[] args) {
        int column1 = 1;  // Output: "A"
        int column2 = 28; // Output: "AB"
        int column3 = 701; // Output: "ZY"

        System.out.println(getColumnName(column1));
        System.out.println(getColumnName(column2));
        System.out.println(getColumnName(column3));
    }
}

