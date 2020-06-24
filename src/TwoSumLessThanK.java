import java.util.Arrays;

/**
 * 1099. Two Sum Less Than K
 * https://leetcode.com/problems/two-sum-less-than-k/
 * June 23rd
 */
public class TwoSumLessThanK {
    public int twoSumLessThanK(int[] A, int K) {
        int res = -1;
        if (A == null || A.length == 0) {
            return res;
        }
        Arrays.sort(A);
        int l = 0;
        int r = A.length - 1;
        int sum = 0;
        while (l < r) {
            sum = A[l] + A[r];
            if (sum >= K) {
                r--;
            } else {
                res = Math.max(sum, res);
                l++;
            }
        }
        return res;
    }



    public static void main(String[] args) {
        TwoSumLessThanK twoSumLessThanK = new TwoSumLessThanK();
        int[] A = new int[]{254,914,110,900,147,441,209,122,571,942,136,350,160,127,178,839,201,386,462,45,735,467,153,415,875,282,204,534,639,994,284,320,865,468,1,838,275,370,295,574,309,268,415,385,786,62,359,78,854,944};
        int K = 200;
        System.out.println(twoSumLessThanK.twoSumLessThanK(A, K));
    }
}
