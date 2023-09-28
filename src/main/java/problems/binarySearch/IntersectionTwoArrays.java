package problems.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntersectionTwoArrays {
    public static int[] Solution(int[] nums1, int[] nums2) {

        int[] temp = new int[1001];

        for (int i = 0; i < nums1.length; i++) {
            temp[nums1[i]] = 1;
        }

        int count = 0;
        for (int i = 0; i < nums2.length; i++) {
            if(temp[nums2[i]] == 1) {
                temp[nums2[i]] = 2;
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;

        for (int i = 0; i < temp.length; i++) {
            if(temp[i] == 2) {
                result[index++] = i;
            }
        }

        return result;
//
//        List<Integer> result = new ArrayList<>();
//        List<Integer> num2List = Arrays.stream(nums2)
//                .boxed()
//                .collect(Collectors.toList());
//        for (int elem : nums1) {
//            if (num2List.contains(elem) && !result.contains(elem)) {
//                result.add(elem);
//            }
//        }
//
//        return result.stream().mapToInt(i -> i).toArray();
    }


    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 2, 1}, num2 = new int[]{2, 2};
        System.out.println(Solution(num1, num2));
    }
}
