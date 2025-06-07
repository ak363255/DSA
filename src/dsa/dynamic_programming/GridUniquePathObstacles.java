package dsa.dynamic_programming;

//https://leetcode.com/problems/unique-paths-ii/
public class GridUniquePathObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length,col = obstacleGrid[0].length;
        if(obstacleGrid[row-1][col-1]==1)return 0;
        if(obstacleGrid[0][0]==1)return 0;
        int [][]dp = new int[row][col];
        dp[0][0] = 1;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(i== 0 && j ==0)continue;
                int count = 0;
                if(isValidMove(i-1,j,row,col,obstacleGrid))count += dp[i-1][j];
                if(isValidMove(i,j-1,row,col,obstacleGrid))count += dp[i][j-1];
                dp[i][j] = count;
            }
        }

        return dp[row-1][col-1];
    }

    public static int findUniquePathsWithObstacles(int i,int j, int [][]grid,int row,int col){
        if(i==0 && j==0)return 1;
        int count = 0;
        if(isValidMove(i-1,j,row,col,grid))count += findUniquePathsWithObstacles(i-1,j,grid,row,col);
        if(isValidMove(i,j-1,row,col,grid))count += findUniquePathsWithObstacles(i,j-1,grid,row,col);
        return count;
    }
    public static boolean isValidMove(int i,int j ,int row,int col,int [][]grid){
        if(i<0 || i>=row || j < 0 || j>= col || grid[i][j]==1)return false;
        return true;
    }
}
