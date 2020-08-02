/**
 * 1246. Palindrome Removal
 * https://leetcode.com/problems/palindrome-removal/
 * Aug. 1st
 */
public class PalindromeRemoval {
    public int minimumMovesBottomUp(int[] arr) {
        int N = arr.length;
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++)
                dp[i][j] = 0;
        }
        for (int len = 1; len <= N; len++) {
            for (int i = 0, j = len - 1; j < N; i++, j++) {
                if (len == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 1 + dp[i + 1][j];
                    if (arr[i] == arr[i + 1]) {
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i + 2][j]);
                    }
                    for (int k = i + 2; k <= j; k++) {
                        if (arr[i] == arr[k]) {
                            dp[i][j] = Math.min(dp[i + 1][k - 1] + dp[k + 1][j], dp[i][j]);
                        }
                    }
                }
            }
        }
        return dp[0][N - 1];
    }

    int[][] dp;
    public int minimumMovesUpBottom(int[] A) {
        int n = A.length;
        dp = new int[n][n];
        return dfs(0, n - 1, A);
    }
    int dfs(int i, int j, int[] A) {
        if (i > j) return 0;
        if (dp[i][j] > 0) return dp[i][j];
        int res = dfs(i, j - 1, A) + 1;
        if (j > 0 && A[j] == A[j - 1])
            res = Math.min(res, dfs(i, j - 2, A) + 1);
        for (int k = i; k < j - 1; ++k)
            if (A[k] == A[j])
                res = Math.min(res, dfs(i, k - 1, A) + dfs(k + 1, j - 1, A));
        dp[i][j] = res;
        return res;
    }

    public static void main(String[] args) {
        PalindromeRemoval palindromeRemoval = new PalindromeRemoval();
        int[] arr = new int[]{1, 3, 4, 1, 5};
        System.out.println(palindromeRemoval.minimumMovesBottomUp(arr));
        System.out.println(palindromeRemoval.minimumMovesUpBottom(arr));
    }
}
