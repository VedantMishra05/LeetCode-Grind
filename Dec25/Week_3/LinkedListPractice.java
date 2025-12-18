package Dec25.Week_3;
class Node {
    int val;
    Node next;

    Node(int x) {
        this.val = x;
        this.next = null;
    }
}
class LeafNode {
    int val;
    LeafNode left;
    LeafNode right;

    LeafNode(int x) {
        this.val = x;
        this.left = null;
        this.right = null;
    }
    LeafNode(int x, LeafNode a, LeafNode b) {
        this.val = x;
        this.left = a;
        this.right = b;
    }
}

public class LinkedListPractice {

    // Detect cycle in a ll
    public static boolean hasCycle(Node head) {
        if(head == null) return false;

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }

        return false;
    }

    // Recursive insertion of nodes in a ll
    public static void recInsert(int val, int index) {
        
    }

    // Max Depth
    public static int maxDepth(LeafNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right)); 
    }

    // Happy Number
    public static int getNext(int n) {
        int num = 0;
        while(n > 0) {
            int digit = n % 10;
            num += digit * digit;
            n /= 10;
        }
        return num;
    }
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        } while(slow != fast);

        return slow == 1;
    }

    // Same Tree
    public static boolean isSame(LeafNode a, LeafNode b) {
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
        if(a.val != b.val) return false;
        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }


    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println(hasCycle(n1));
        
        n5.next = n3;
        
        System.out.println(hasCycle(n1));

        System.out.println();
        System.out.println(isHappy(121));

    }
}
