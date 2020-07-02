/**
 * 367. Valid Perfect Square
 * https://leetcode.com/problems/valid-perfect-square/
 * July 2nd
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }

        int lo = 1;
        int hi = num/2;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (num/mid < mid) {
                hi = mid - 1;
            } else if (num/mid > mid){
                lo = mid + 1;
            } else {
                return num == mid * mid;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
        int num = 14;
        System.out.println(validPerfectSquare.isPerfectSquare(num));
    }
}
