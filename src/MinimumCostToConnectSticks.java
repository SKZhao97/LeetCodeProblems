import java.util.PriorityQueue;

/**
 * 1167. Minimum Cost to Connect Sticks
 * https://leetcode.com/problems/minimum-cost-to-connect-sticks/
 * June 23rd
 */
public class MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        int res = 0;
        if (sticks == null || sticks.length == 0) {
            return res;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int stick : sticks) {
            pq.offer(stick);
        }
        while(pq.size() > 1) {
            int stick1 = pq.poll();
            int stick2 = pq.poll();
            int stickSum = stick1 + stick2;
            res += stickSum;
            pq.offer(stickSum);
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumCostToConnectSticks minimumCostToConnectSticks = new MinimumCostToConnectSticks();
        int[] sticks = new int[]{1, 8, 3, 5};
        System.out.println(minimumCostToConnectSticks.connectSticks(sticks));
    }
}
