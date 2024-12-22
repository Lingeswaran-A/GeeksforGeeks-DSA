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

            if (x.searchRowMatrix(matrix, target))
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
    public boolean searchRowMatrix(int[][] mat, int x) {
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++){
            if(bsearch(mat[i],x)){
                return true;
            }
        }
        return false;
    }
    public boolean bsearch(int[] mat,int x){
        int l=0,h=mat.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(mat[mid]==x){
                return true;
            }
            else if(mat[mid]>x){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return false;
    }
}
