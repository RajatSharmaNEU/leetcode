package Oracle;

public class RomanToInt {
    public int getVal(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public int romanToInt(String s) {
        int result = 0;
        int n = s.length();
        for (int i = 0; i < s.length(); i++) {
            int currVal = getVal(s.charAt(i));
            if(i < n-1 && currVal < getVal(s.charAt(i + 1))) {
                result = result - currVal;
            }else {
                result = result + currVal;
            }
        }

        return result;
    }
}
