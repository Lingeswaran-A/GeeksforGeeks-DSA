//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int isCircle(String arr[]) {
        int[] in=new int[26];  
        int[] out=new int[26]; 
        Map<Character,List<Character>> graph=new HashMap<>();
        for(String str : arr){
            char first=str.charAt(0);
            char last = str.charAt(str.length()-1);
            graph.putIfAbsent(first, new ArrayList<>());
            graph.get(first).add(last);
            out[first-'a']++;
            in[last-'a']++;
        }
        for(int i=0;i<26;i++){
            if(in[i]!=out[i]) return 0;
        }
        return isConnected(graph,arr[0].charAt(0)) ? 1 : 0;
    }
    private static boolean isConnected(Map<Character, List<Character>> graph,char start) {
        Set<Character> visited = new HashSet<>();
        dfs(graph, start, visited);
        for(char node:graph.keySet()){
            if (!visited.contains(node)) return false;
        }
        return true;
    }
    private static void dfs(Map<Character,List<Character>> graph,char node,Set<Character> visited){
        visited.add(node);
        if (graph.containsKey(node)) {
            for (char neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    dfs(graph, neighbor, visited);
                }
            }
        }
    }
}