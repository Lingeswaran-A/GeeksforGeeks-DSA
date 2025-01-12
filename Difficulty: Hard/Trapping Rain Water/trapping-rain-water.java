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
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxWater(int arr[]) {
        int left = 1;
        int right = arr.length - 2;
        int max_left = arr[left - 1];
        int max_right = arr[right + 1];
        int res = 0;
        while (left <= right) {
            if (max_right <= max_left) {
                res += Math.max(0, max_right - arr[right]);
                max_right = Math.max(max_right, arr[right]);
                right -= 1;
            } else { 
                res += Math.max(0, max_left - arr[left]);
                max_left = Math.max(max_left, arr[left]);
                left += 1;
            }
        }
        return res;
    }
}
