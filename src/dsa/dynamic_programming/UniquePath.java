package dsa.dynamic_programming;

//https://leetcode.com/problems/unique-paths/
public class UniquePath {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                int count = 0;
                count += ((i - 1 >= 0 ? dp[i - 1][j] : 0) + (j - 1 >= 0 ? dp[i][j - 1] : 0));
                dp[i][j] = count;
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int findUniquePaths(int i, int j) {
        if (i < 0 || j < 0) return 0;
        if (i == 0 && j == 0) return 1;
        int count = 0;
        count += (findUniquePaths(i - 1, j) + findUniquePaths(i, j - 1));
        return count;
    }
}
