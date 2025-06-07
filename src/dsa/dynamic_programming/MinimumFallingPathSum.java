package dsa.dynamic_programming;

public class MinimumFallingPathSum {
    //https://leetcode.com/problems/minimum-falling-path-sum/
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length,col = matrix[0].length;
        int ans = Integer.MAX_VALUE;
        int [][]dp = new int[row][col];
        for(int j = 0;j<col;j++){
            dp[0][j] = matrix[0][j];
        }
        for(int i = 1;i<row;i++){
            for(int j = 0;j<col;j++){
                int sum = Integer.MAX_VALUE;
                if(isValidMove(i-1,j,row,col))sum =Math.min(sum,matrix[i][j] + dp[i-1][j]) ;
                if(isValidMove(i-1,j-1,row,col))sum = Math.min(sum,matrix[i][j]+dp[i-1][j-1]);
                if(isValidMove(i-1,j+1,row,col))sum = Math.min(sum,matrix[i][j]+dp[i-1][j+1]);
                dp[i][j]  = sum;
            }
        }
        for(int j = 0;j<col;j++){
            ans = Math.min(dp[row-1][j],ans);
        }
        return ans;
    }
    public static int findMinFallingPathSum(int i,int j,int row,int col,int [][]matrix){
        if(i==0)return matrix[0][j];
        int sum = Integer.MAX_VALUE;
        if(isValidMove(i-1,j,row,col))sum =Math.min(sum,matrix[i][j] + findMinFallingPathSum(i-1,j,row,col,matrix)) ;
        if(isValidMove(i-1,j-1,row,col))sum = Math.min(sum,matrix[i][j]+findMinFallingPathSum(i-1,j-1,row,col,matrix));
        if(isValidMove(i-1,j+1,row,col))sum = Math.min(sum,matrix[i][j]+findMinFallingPathSum(i-1,j+1,row,col,matrix));
        return sum;
    }
    public static boolean isValidMove(int i,int j,int row,int col){
        if(i<0||i>=row||j<0||j>=col)return false;
        return true;
    }
}
