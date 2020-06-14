/**
 * 5455. Minimum Number of Days to Make m Bouquets
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 * June 13th
 */
public class MinimumNumberOfDaysToMakeMBouquet {
    /**
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) {
            return -1;
        }

        int res = Integer.MAX_VALUE;
        for (int n = 0; n < k; n++) {
            if (bloomDay.length - n >= m * k) {
                List<Integer> maximums = new ArrayList<>();
                int max = 0;
                for (int i = 0 ; i < bloomDay.length; i++) {
                    max = Math.max(max, bloomDay[i]);
                    if ((i + 1) % k ==0) {
                        maximums.add(max);
                        max = 0;
                    }
                }
                Collections.sort(maximums);
                res = Math.min(maximums.get(m - 1), res);
            }
        }

        return res;
    }
    **/

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length, left = 1, right = (int)1e9;
        if (m * k > n) return -1;
        while (left < right) {
            int mid = (left + right) / 2, flow = 0, bouq = 0;
            for (int j = 0; j < n; j++) {
                if (bloomDay[j] > mid) {
                    flow = 0;
                } else if (++flow >= k) {
                    bouq++;
                    flow = 0;
                }
            }
            if (bouq < m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left);
        System.out.println(right);

        return left;
    }

    public static void main(String[] args) {
        MinimumNumberOfDaysToMakeMBouquet minimumNumberOfDaysToMakeMBouquet = new MinimumNumberOfDaysToMakeMBouquet();
        int[] bloomDay = new int[]{5,37,55,92,22,52,31,62,99,64,92,53,34,84,93,50,28};
        int m = 8;
        int k = 2;
        System.out.println(minimumNumberOfDaysToMakeMBouquet.minDays(bloomDay, m, k));
    }
}
