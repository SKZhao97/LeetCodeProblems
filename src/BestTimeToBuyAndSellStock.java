/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * June 11th
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,1,5,3,6,4};
        BestTimeToBuyAndSellStock bestTimetoBuyAndSellStock = new BestTimeToBuyAndSellStock();
        System.out.println(bestTimetoBuyAndSellStock.maxProfit(nums));
    }
}
