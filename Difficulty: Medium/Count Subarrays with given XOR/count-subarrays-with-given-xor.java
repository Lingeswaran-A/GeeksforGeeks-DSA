//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long subarrayXor(int arr[], int k) {
        int res = 0;
        HashMap<Integer, Integer> hmap=new HashMap<>();
        int pref_xor = 0;
        for (int val : arr) {
            pref_xor ^= val;
            res += hmap.getOrDefault(pref_xor ^ k, 0);
            if (pref_xor == k)
                res++;
            hmap.put(pref_xor, hmap.getOrDefault(pref_xor, 0) + 1);
        }
        return res;
    }
}