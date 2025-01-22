//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


// } Driver Code Ends
/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
    static Node addTwoLists(Node num1, Node num2) {
        num1 = trimLeadingZeros(num1);
        num2 = trimLeadingZeros(num2);
      
        // Find the length of both the linked lists
        int len1 = countNodes(num1);
        int len2 = countNodes(num2);

        // If num1 is smaller, swap the two linked lists by
        // calling the function with reversed parameters
        if (len1 < len2) {
            return addTwoLists(num2, num1);
        }

        int carry = 0;
        num1 = reverse(num1);
        num2 = reverse(num2);

        Node res = num1;

        // Iterate till either num2 is not empty or
        // carry is greater than 0
        while (num2 != null || carry != 0) {

            // Add carry to num1
            num1.data += carry;

            // If num2 linked list is not empty, add it to num1
            if (num2 != null) {
                num1.data += num2.data;
                num2 = num2.next;
            }

            // Store the carry for the next nodes
            carry = num1.data / 10;

            // Store the remainder in num1
            num1.data = num1.data % 10;

            // If we are at the last node of num1 but carry is
            // still left, then append a new node to num1
            if (num1.next == null && carry != 0) {
                num1.next = new Node(0);
            }

            num1 = num1.next;
        }

        // Reverse the resultant linked list to get the
        // required linked list
        return reverse(res);
    }
    static Node trimLeadingZeros(Node head) {
        while (head != null && head.data == 0) {
            head = head.next;
        }
        return head;
    }
    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Function to find the length of linked list
    static int countNodes(Node head) {
        int len = 0;
        Node curr = head;

        while (curr != null) {
            len += 1;
            curr = curr.next;
        }
        return len;
    }
}

//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends