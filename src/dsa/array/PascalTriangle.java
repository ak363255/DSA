package dsa.array;

import java.util.ArrayList;

public class PascalTriangle {

    public static int[][] pascalTriangle(int N) {
       /*
           1
           1 1
           1 2 1
           1 3 3 1
           1 4 6 4 1

           (5,1)  (5,2)  (5,3)  (5,4) (5,5)

           1      1*(4/1)      1*(4/1)(3/2)   1*(4/1)*(3/2)*(2/3)   1*(4/1)*(3/2)*(2/3)*(1/4)

            FOR  n = 5
            for-> i = 1 to 4
                 ans[i] = ans[i-1]*(n-i)
                 ans[i] = ans[i]/(i);

        */
        int[][] ans = new int[N][N];
        for(int i = 1;i<=N;i++){
            ans[i-1] = getPascalTriangleForRow(i);
        }
        return  ans;
    }
    public static int[] getPascalTriangleForRow(int n){
        int []row = new int[n];
        row[0] = 1;
        for(int i= 1;i<n;i++){
            int value = row[i-1]*(n-i);
            value = value/i;
            row[i] = value;
        }
        return row;
    }
}
