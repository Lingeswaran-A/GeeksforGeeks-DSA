//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] mat = new char[n][m];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            String word = sc.next();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(mat, word);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    static public boolean isWordExist(char[][] mat, String word) {
        int wLen=word.length();
        int row=mat.length;
        int col=mat[0].length;
        if(wLen>row*col)
            return false;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==word.charAt(0)) {
                    if(findMatch(mat,word,i,j,0))
                        return true;
                }
            }
        }
        return false;
    }
    static boolean findMatch(char[][] mat,String word,int x,int y,int wIdx) {
        int wLen=word.length();
        int row=mat.length;
        int col=mat[0].length;
        if(wIdx==wLen)
            return true;
        if(x<0 || y<0 || x>=row || y>=col)
            return false;
        if(mat[x][y]==word.charAt(wIdx)){
            char temp=mat[x][y];
            mat[x][y]='#';
            boolean res=findMatch(mat,word,x-1,y,wIdx+1) ||
                          findMatch(mat,word,x+1,y,wIdx+1) ||
                          findMatch(mat,word,x,y-1,wIdx+1) ||
                          findMatch(mat,word,x,y+1,wIdx+1);
            mat[x][y]=temp;
            return res;
        }
        return false;
    }
}