import java.util.*;

/**
 * 349. Intersection of Two Arrays
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * June 29th
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        Set<Integer> set = new HashSet<>();
        Set<Integer> ans = new HashSet<>();
        for (int i = 0; i < len1; i++) {
            set.add(nums1[i]);
        }
        for (int j = 0; j < len2; j++) {
            if (set.contains(nums2[j])) {
                ans.add(nums2[j]);
            }
        }
        int[] res = new int[ans.size()];
        int k = 0;
        for (int val : ans) {
            res[k++] = val;
        }
        return res;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        System.out.println(Arrays.toString(intersectionOfTwoArrays.intersection(nums1, nums2)));
    }
}
