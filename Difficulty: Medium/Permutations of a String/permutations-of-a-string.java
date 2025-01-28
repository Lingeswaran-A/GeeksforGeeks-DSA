//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPermutation(String s) {
        ArrayList<String> res = new ArrayList<>(); 
        Map<Character, Integer> cnt = new HashMap<>(); 
        for(char c:s.toCharArray()){ 
            cnt.put(c, cnt.getOrDefault(c,0)+1);
        }
        StringBuilder curr=new StringBuilder();
        genPermutations(s.length(),curr,cnt,res);
        return res;
    }
    static void genPermutations(int n,StringBuilder curr,Map<Character,Integer> cnt, List<String> res) {
        if (curr.length() == n) {
            res.add(curr.toString());
            return;
        }
        for (Map.Entry<Character, Integer> entry : cnt.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            if (count == 0) 
                continue;
            curr.append(c);
            cnt.put(c, count - 1);
            genPermutations(n, curr, cnt, res);
            curr.deleteCharAt(curr.length() - 1);
            cnt.put(c, count);
        }
    }
}