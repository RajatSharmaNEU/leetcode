package problems.binarySearch;

//  Find the smallest Letter Greater Than Target
// https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
class FindNextGreatestLetter {
    public static char Solution(char[] letters, char target) {
        int low = 0, high = letters.length - 1;
        while (low < high) {
            int mid = (high + low) / 2;

            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        System.gc();
        if (letters[high] > target) return letters[high];
        return letters[0];

//        int low = 0, high = letters.length-1;
//        int mid = -1;
//        while (low <= high){
//            mid = (int)Math.ceil(low + (high - low)/2);
//
//            if(letters[mid] == target) {
//                while(letters[mid] == target && mid < high){
//                    mid++;
//                }
//                break;
//            } else if (letters[mid] > target) {
//                high--;
//            } else {
//                low++;
//            }
//        }
//
//        if(mid == 0) {
//            return letters[0];
//        } else if(mid == letters.length-1 && letters[mid] <= target) {
//            return letters[0];
//        } else {
//            return letters[mid];
//        }
    }


    public static void main(String[] args) {
        char[] letters1 = new char[]{'c', 'f', 'j'};
        char target1 = 'a';
        char result1 = 'c';

//        char[] letters2 = new char[]{'c', 'f', 'j'};
//        char target2 = 'c';
//        char result2 = 'f';
//
//        char[] letters3 = new char[]{'x', 'x', 'y', 'y'};
//        char target3 = 'z';
//        char result3 = 'x';
//
//        char[] letters4 = new char[]{'e', 'e', 'g', 'g'};
//        char target4 = 'g';
//        char result4 = 'e';
//
//        char[] letters5 = new char[]{'c', 'f', 'g'};
//        char target5 = 'g';
//        char result5 = 'c';

        System.out.println(Solution(letters1, target1) == result1);
//        System.out.println(Solution(letters2, target2) == result2);
//        System.out.println(Solution(letters3, target3) == result3);
//        System.out.println(Solution(letters4, target4) == result4);
//        System.out.println(Solution(letters5, target5) == result5);
    }
}
