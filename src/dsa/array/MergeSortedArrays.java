package dsa.array;

public class MergeSortedArrays {

    public static void mergeTwoSortedArraysWithoutExtraSpace(long[] a, long[] b) {
         /*
         When ‘N’ = 4, ‘A’ = {1, 4, 5, 7} and ‘M’ = 3, ‘B’ = {2, 3, 6}.

                  gap = ceil(7/2) = 4
                   1  4  5  7         2  3  6    1  3  5  7    2  4  6    1  3  5  7   2  4  6
           gap =4  i                 j              i             j             i            j

                   1  3  5  7     2  4  6   1  3  2  4  5  7  6
           gap=2   i     j                              i     j

           gap=1   1  2  3  4   5  6  7
                                   i  j

                                   floor(gap/2)==0 break;

          */

        int n = a.length,m = b.length, gap = (int)Math.ceil((n+m)/2.0),i,j;
        long temp;
        while(true){
            i = 0;
            j = gap;
            while(j < (n+m) && i<j){
                if(i < n && j < n){
                    if(a[i] > a[j]){
                        temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }

                }else if(i>=n && j>=n){
                    if(b[i-n] > b[j-n]){
                        temp = b[i-n];
                        b[i-n] = b[j-n];
                        b[j-n] = temp;
                    }
                }else{
                    if(a[i] > b[j-n]){
                        temp = a[i];
                        a[i] = b[j-n];
                        b[j-n] = temp;
                    }
                }
                i++;
                j++;
            }
            if((int)Math.floor(gap/2.0)==0)break;
            gap = (int)Math.ceil(gap/2.0);
        }

    }
}
