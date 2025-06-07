package dsa.dynamic_programming;

//https://www.naukri.com/code360/problems/ninja-s-training_3621003
public class NinjaTraining {
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int [][]dp = new int[points.length][3];
        dp[0][0] = points[0][0];
        dp[0][1] = points[0][1];
        dp[0][2] = points[0][2];
            for(int i = 1;i<points.length;i++){
                for(int j = 0;j<3;j++){
                    int ans = 0;
                    ans = Math.max(ans,dp[i-1][(j+1)%3] + points[i][j]);
                    ans = Math.max(ans,dp[i-1][(j+2)%3] + points[i][j]);
                    dp[i][j]= ans;
                }
            }

        return Math.max(dp[points.length-1][0],Math.max(dp[points.length-1][1],dp[points.length-1][2]));

       /* int ans = 0;
        for(int i = 0;i<=2;i++){
            ans = Math.max(ans,findNinjaTraining(points.length-1,i,points));
        }
        return ans;*/
    }
    public static int findNinjaTraining(int i,int j,int points[][]){
        if(i==0)return Math.max(points[0][(j+1)%3],points[0][(j+2)%3]);
        int ans = 0;
        ans = Math.max(ans,findNinjaTraining(i-1,(j+1)%3,points)+points[i][(j)%3]);
        ans = Math.max(ans,findNinjaTraining(i-1,(j+2)%3,points) + points[i][(j)%3]);
        return ans;
    }
}
