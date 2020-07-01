/**
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/
 * July 1st
 */
public class HouseRobber {
//    public int rob(int[] nums) {
//        if (nums==null || nums.length ==0) return 0;
//        int rob =0 ;
//        int notrob = 0;
//        for(int i = 0; i < nums.length; i++){
//            int prerob = rob, prenotrob = notrob;
//            rob = nums[i] + prenotrob;
//            notrob = Math.max(prerob,prenotrob);
//        }
//        return Math.max(rob,notrob);
//
//    }

    public int rob(int[] nums) {
        int [] dp = new int[nums.length + 2];
        for(int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 2], dp[i - 1]);
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(nums));
    }
}
