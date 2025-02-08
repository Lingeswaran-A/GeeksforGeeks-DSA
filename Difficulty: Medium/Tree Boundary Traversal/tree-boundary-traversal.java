//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution T = new Solution();

            ArrayList<Integer> res = T.boundaryTraversal(root);
            for (Integer num : res) System.out.print(num + " ");
            System.out.println();
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> res = new ArrayList<>();
        if (node== null)
            return res;
        if (!isLeaf(node))
            res.add(node.data);
        collectBoundaryLeft(node.left, res);
        collectLeaves(node, res);
        collectBoundaryRight(node.right, res);
        return res;
    }
    static void collectBoundaryRight(Node root, ArrayList<Integer> res) {
        if (root == null)
            return;
        Node curr = root;
        ArrayList<Integer> temp = new ArrayList<>();
        while (!isLeaf(curr)) {
            temp.add(curr.data);
            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }
        for (int i = temp.size() - 1; i >= 0; --i)
            res.add(temp.get(i));
    }
    static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }
    static void collectBoundaryLeft(Node root, ArrayList<Integer> res) {
        if (root == null)
            return;
        Node curr = root;
        while (!isLeaf(curr)) {
            res.add(curr.data);
            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }
    static void collectLeaves(Node root, ArrayList<Integer> res) {
        Node current = root;
        while (current != null) {
            if (current.left == null) {
                if (current.right == null) 
                    res.add(current.data);

                current = current.right;
            } 
              else {
                Node predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } 
                  else {
                    if (predecessor.left == null) 
                        res.add(predecessor.data);
                    
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
    }
}
