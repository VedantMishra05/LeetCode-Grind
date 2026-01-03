package Y_25_m12_Dec.Week_4;
import java.util.*;

import Y_25_m12_Dec.Week_4.PracticeLinkedList.Node;

@SuppressWarnings("unused")
public class Practice {

    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Valid Sudoku
    public boolean validSudoku(int[][] matrix) {

        return true;
    }

    // Queue using stacks..
    Stack<Integer> a = new Stack<>();
    Stack<Integer> b = new Stack<>();
    private void offer(int val) {
        a.push(val);
    }
    private int poll() {
        if(a.isEmpty() && b.isEmpty()) throw new IllegalStateException("Queue is empty.");
        if(b.isEmpty()) {
            while(!a.isEmpty()) b.push(a.pop());
        }
        return b.pop();
    }

    // Game of Stack (HackerRank)
    private int maxMoves(Stack<Integer> a, Stack<Integer> b, int moves, int currSum, int maxSum) {
        if(currSum > maxSum) return moves - 1;
        int max = moves;

        if(!a.isEmpty()) {
            int a1 = a.pop();
            max = Math.max(max, maxMoves(a, b, moves + 1, currSum + a1, maxSum));
            a.push(a1);
        }
        if(!b.isEmpty()) {
            int b1 = b.pop();
            max = Math.max(max, maxMoves(a, b, moves + 1, currSum + b1, maxSum));
            b.push(b1);
        }
        return max;
    }
    // grredy approach
    private int maxMoves(int[] a, int[] b, int maxSum) {
        int moves = 0, countA = 0, sum = 0;
        while(countA < a.length && sum + a[countA] < maxSum) {
            sum += a[countA];
            countA++;
        }
        moves = countA;

        int countB = 0;
        while(countB < b.length) {
            sum += b[countB];
            countB++;

            while(sum > maxSum && countA > 0) {
                countA--;
                sum -= a[countA]; // kyuki ek baar galat pe bhi badha tha ye..
            }

            if(sum <= maxSum) {
                moves = Math.max(moves, countA + countB);
            }
        }
        
        return moves;
    }

     // Game of Life
    public void gameOfLife(int[][] board) {
        
    }

    // Delete the given node in the argument - given is not the tail.
    private void delete(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    // Intersection of two linked lists - return intersecting node
    private Node areIntersecting(Node headA, Node headB) {
        Node a = headA;
        Node b = headB;

        while(a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }

    // Power of two - it has only 1 bit in binary
    private boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // Longest palindrome - return length of longest palindrome
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        for(char c: s.toCharArray()) {
            freq[c]++;
        }

        int length = 0;
        boolean hasOdd = false;

        for(int count: freq) {
            if(count % 2 == 0) {
                length += count;
            } else {
                length += count - 1;
            }
        }
        return hasOdd ? length + 1 : length;
    }

    // Rotate Linked List by k
    public static Node rotateRight(Node head, int k) {
        if(head == null) return head;

        int size = 1;
        Node tail = head;
        while(tail.next != null) { tail = tail.next; size++; }

        k = k % size; 
        Node newTail = head;
        if(k == 0) return head;
        for(int i = 0; i < size - k - 1; i++) newTail = newTail.next;

        tail.next = head;
        Node newHead = newTail.next;
        newTail.next = null;
        
        return newHead;
    }

    // Reverse Linked List II - reverse between left and right
    public Node reverseBetween(Node head, int left, int right) {
        if(head == null) return head;

        Node dummy = new Node(0);
        dummy.next = head;

        Node prev = dummy;
        for(int i = 1; i < left; i++) prev = prev.next;
        Node curr = prev.next;

        for(int i = 0; i < right - left; i++) {
            Node next = curr.next;
            curr.next = next.next;
            next.next = curr;
            prev.next = next;
        }
        return dummy.next;
    }

    // Partition List
    public Node partition(Node head, int x) {

        return head;
    }

    // Remove nth node from end
    public Node removeNthFromEnd(Node head, int n) {
        return head;
    }

    // Merge two sorted lists
    public Node mergeTwoLists(Node l1, Node l2) {
        return l1;
    }

    // Delete the middle node of a linked list
    public Node deleteMiddle(Node head) {
        return head;
    }

    // Reorder list
    public void reorderList(Node head) {
        // placeholder
    }

    // Insertion sort in linked list
    public Node insertionSortList(Node head) {
        return head;
    }

    // Swap nodes in a linked list
    public Node swapNodes(Node head, int k) {
        return head;
    }

    // Remove smaller nodes in a linked list
    public Node removeSmallerNodes(Node head) {
        return head;
    }

    public static void main(String[] args) {
        PracticeLinkedList list = new PracticeLinkedList();
    }
}
