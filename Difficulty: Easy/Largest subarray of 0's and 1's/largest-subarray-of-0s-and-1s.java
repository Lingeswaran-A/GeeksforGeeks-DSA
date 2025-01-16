//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Create BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of test cases
        int T = Integer.parseInt(br.readLine());

        // Process each test case
        while (T-- > 0) {
            // Read the entire line containing the array elements
            String line = br.readLine();

            // Split the line into an array of strings, then parse them as integers
            String[] tokens = line.split("\\s+");
            int[] a = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                a[i] = Integer.parseInt(tokens[i]);
            }

            // Create the Solution object
            Solution obj = new Solution();

            // Call maxLen function and print the result
            System.out.println(obj.maxLen(a));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxLen(int[] arr) {
        HashMap<Integer,Integer> hmap=new HashMap<>();
        int pref=0;
        int ans=0;
        for(int i=0;i<arr.length;i++){
            pref+=(arr[i]==0) ? -1:1;
            if(pref==0)
                ans=i+1;
            if(hmap.containsKey(pref))
                ans=Math.max(ans,i-hmap.get(pref));
            else
                hmap.put(pref,i);
        }
        return ans;
    }
}
