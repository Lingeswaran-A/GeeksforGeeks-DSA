//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxProfit(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;
        int[][] curr = new int[3][2];
        int[][] next = new int[3][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int k = 1; k <= 2; k++) {
                curr[k][1] = Math.max(-prices[i] + next[k][0], next[k][1]);
                curr[k][0] = Math.max(prices[i] + next[k - 1][1], next[k][0]);
            }
            next = curr.clone();
        }
        return curr[2][1];
    }
}
