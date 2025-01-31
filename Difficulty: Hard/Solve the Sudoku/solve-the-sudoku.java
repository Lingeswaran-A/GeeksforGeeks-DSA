//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = 9;
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.solveSudoku(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find a solved Sudoku.
    static void solveSudoku(int[][] mat) {
        int n=mat.length;
        int[] row=new int[n];
        int[] col=new int[n];
        int[] box=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]!=0){
                    row[i]|=(1<<mat[i][j]);
                    col[j]|=(1<<mat[i][j]);
                    box[(i/3)*3+j/3] |= (1<<mat[i][j]);
                }
            }
        }
        Recursion_Solver(mat,0,0,row,col,box);
    }
    static boolean Recursion_Solver(int[][] mat,int i,int j,int[] row,int[] col,int[] box){
        int n=mat.length;
        if(i==n-1 && j==n) return true;
        if(j==n){
            i++;
            j=0;
        }
        if(mat[i][j]!=0) return Recursion_Solver(mat,i,j+1,row,col,box);
        for(int num=1;num<=n;num++){
            if(isSafe(mat,i,j,num,row,col,box)){
                mat[i][j]=num;
                row[i] |= (1 << num);
                col[j] |= (1 << num);
                box[i / 3 * 3 + j / 3] |= (1 << num);
                if (Recursion_Solver(mat, i, j + 1, row, col, box))
                    return true;
                mat[i][j] = 0;
                row[i] &= ~(1 << num);
                col[j] &= ~(1 << num);
                box[i / 3 * 3 + j / 3] &= ~(1 << num);
            }
        }
        return false;
    }
    static boolean isSafe(int[][] mat,int i,int j,int num,int[] row,int[] col,int[] box){
        if((row[i] & (1<<num))!=0 || (col[j] & (1<<num))!=0 || (box[i/3*3+j/3] & (1<<num))!=0){
            return false;
        }
        return true;
    }
}