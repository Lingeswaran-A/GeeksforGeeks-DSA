//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            int[] ans = new int[n];
            ans = ob.productExceptSelf(arr);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int n=arr.length,idx=-1,z=0,prod=1;
        int[] res=new int[n+1];
        Arrays.fill(res,0);
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                idx=i;
                z++;
            }
            else prod*=arr[i];
        }
        if(z==0){
            for(int i=0;i<n;i++){
                res[i]=prod/arr[i];
            }
        }
        if(z==1) res[idx]=prod;
        return res;
    }
}
