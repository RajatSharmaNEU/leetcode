package GFG.String.Concepts;

public class PrintFrequency {
    // Print frequency in sorted order
    public static void main(String[] args) {
        // Logic
//        int x = 'z' - 'a';
//        char y = (char)(x + 'a');
//
//        System.out.println(x);
//        System.out.println(y);

        String input = "geeksforgeeks";
        int[] count = new int[26];

        for (int i = 0; i < input.length(); i++) {
            int index = input.charAt(i) - 'a';
            count[index]++;
        }

        for (int i = 0; i < count.length; i++) {
            if(count[i] > 0) {
                int charIndexValue = i +'a';
                System.out.println((char)charIndexValue + " - " + count[i]);
            }
        }
    }
}
