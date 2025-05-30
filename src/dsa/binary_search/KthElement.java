package dsa.binary_search;

import java.util.ArrayList;

public class KthElement {

    public static int kthElement(ArrayList<Integer> a, ArrayList<Integer> b, int n, int m, int k) {
        // Write your coder here
        int s = 0, e = a.size(), mid1, ans = -1, mid2, l1, l2, r1, r2;
        while (s <= e) {
            mid1 = (e - s) / 2 + s;
            mid2 = mid1 > k ? 0 :k - mid1;
             if(mid2 <= b.size()){
                l1 = mid1 > 0 ? a.get(mid1 - 1) : Integer.MIN_VALUE;
                r1 = mid1 < a.size() ? a.get(mid1):Integer.MAX_VALUE;
                l2 = mid2 > 0 ? b.get(mid2-1) : Integer.MIN_VALUE;
                r2 = mid2 < b.size() ? b.get(mid2) : Integer.MAX_VALUE;
                if (l1 > r2) {
                    e = mid1 - 1;
                } else if (l2 > r1) {
                    s = mid1 + 1;
                } else {
                    ans = Math.max(l1, l2);
                    break;
                }
            }else{
                s = mid1+1;
            }
        }
        return ans;
    }
}
