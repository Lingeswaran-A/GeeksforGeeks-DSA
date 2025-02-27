//{ Driver Code Starts
import java.util.*;

class Get_Min_From_Stack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        while (T-- > 0) {
            int q = sc.nextInt(); // Number of queries
            Solution g = new Solution();

            while (q-- > 0) {
                int qt = sc.nextInt();

                if (qt == 1) {
                    int att = sc.nextInt();
                    g.push(att);
                } else if (qt == 2) {
                    g.pop(); // Just call pop(), do not print anything
                } else if (qt == 3) {
                    System.out.print(g.peek() + " "); // Print top element
                } else if (qt == 4) {
                    System.out.print(g.getMin() + " "); // Print minimum element
                }
            }
            System.out.println("\n~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    private Stack<int[]> s;
    public Solution() {
        s = new Stack<>();
    }
    public void push(int x) {
        int newMin = s.isEmpty() ? x : Math.min(x, s.peek()[1]);
        s.push(new int[]{x, newMin});
    }

    // Remove the top element from the Stack
    public void pop() {
        if (!s.isEmpty()) {
            s.pop();
        }
    }

    // Returns top element of the Stack
    public int peek() {
        return s.isEmpty() ? -1 : s.peek()[0];
    }

    // Finds minimum element of Stack
    public int getMin() {
        return s.isEmpty() ? -1 : s.peek()[1];
    }
}