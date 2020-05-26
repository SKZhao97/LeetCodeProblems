public class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        if(s.charAt(0) != '0') {
            dp[0] = 1;
            dp[1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            int cur = Integer.parseInt(s.substring(i - 1, i));
            if (cur != 0) {
                dp[i] += dp[i - 1];
            }
            int option = Integer.parseInt(s.substring(i - 2, i));
            if (option <= 26 && option >= 10) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
//        String s = "266";
        String s = "101";
        System.out.println(decodeWays.numDecodings(s));
    }
}
