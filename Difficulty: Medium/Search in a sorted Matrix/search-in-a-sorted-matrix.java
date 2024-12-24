//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int rows = sc.nextInt();
            int columns = sc.nextInt();

            int matrix[][] = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int target = sc.nextInt();

            Solution x = new Solution();

            if (x.searchMatrix(matrix, target))
                System.out.println("true");
            else
                System.out.println("false");
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchMatrix(int[][] mat, int x) {
        int n=mat.length;
        int m=mat[0].length;
        int l=0,h=n-1,i=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            //System.out.print(mid);
            if(mat[mid][0]==x){
                return true;
            }
            if(mat[mid][0]<x){
                i=mid;
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        if(i==-1){
            return false;
        }
        return bsearch(mat[i],x);
    }
    public boolean bsearch(int[] arr,int x){
        int a=0,b=arr.length-1;
        while(a<=b){
            int mid=a+(b-a)/2;
            if(arr[mid]==x){
                return true;
            }
            else if(arr[mid]<x){
                a=mid+1;
            }
            else{
                b=mid-1;
            }
        }
        return false;
    }
}
