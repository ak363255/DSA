package dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class RatMaze {

    public static List<String>ans;
    public static boolean[][]visited;
    public static List<String> findPath(int[][] grid) {
        //your code goes here
        ans = new ArrayList<>();
        visited = new boolean[grid.length][grid[0].length];
        if(grid[grid.length-1][grid.length-1]==0){
            List<String> t = new ArrayList<>();
            t.add("-1");
            return t;
        }
        path(grid,0,0,grid.length,grid[0].length,"");
        return ans;
    }
    public static void path(int [][]grid,int i,int j,int row,int col,String temp){
        if(i==row-1 && j==col-1){
            ans.add(temp);
            return;
        }
        if(i<0 || j<0 || i>= grid.length || j>= grid[0].length || visited[i][j] || grid[i][j]==0)return;
        visited[i][j] = true;

        //go left
        path(grid,i,j-1,row,col,temp+"L");
        //go right
        path(grid,i,j+1,row,col,temp+"R");
        //go top
        path(grid,i-1,j,row,col,temp+"U");
        //go bottom
        path(grid,i+1,j,row,col,temp+"D");
        visited[i][j] = false;
    }
}
