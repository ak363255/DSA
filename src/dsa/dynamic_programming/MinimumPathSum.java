package dsa.dynamic_programming;

public class MinimumPathSum {

    //https://leetcode.com/problems/minimum-path-sum/
    public int minPathSum(int[][] grid) {

        int row = grid.length,col = grid[0].length;
        int [][]dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(i==0 && j==0)continue;
                int count = Integer.MAX_VALUE;
                if(isValidMove(i-1,j,row,col))count = Math.min(count,grid[i][j]+dp[i-1][j]);
                if(isValidMove(i,j-1,row,col))count = Math.min(count,grid[i][j]+dp[i][j-1]);
                dp[i][j] = count;
            }
        }
        return dp[row-1][col-1];
    }
    public static boolean isValidMove(int i,int j,int row,int col){
        if(i<0 || i>=row || j<0 || j>=col)return false;
        return true;
    }
}
