package Y_25_m12_Dec.Week_3;
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

public class LeetcodePractice {

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

    // Balanced Tree : My method
    public static boolean isBalanced(LeafNode root) {
        if(root == null) return true;

        if(Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }
    // Balanced Tree : Optimal method
    public static boolean balanced(LeafNode root) {
        return height(root) != -1;
    }
    public static int height(LeafNode node) {
        if(node == null) return 0;

        int left = height(node.left);
        if(left == -1) return -1;

        int right = height(node.right);
        if(right == -1) return -1;

        if(Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }

    // Symetric Tree
    public static boolean isSymmetric(LeafNode root) {
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }
    public static boolean isMirror(LeafNode left, LeafNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return isMirror(left.left, right.right) && isMirror(left.right, right.left); // opposite same hona chaiye
    }

    // Minimum Depth of Binary Tree : Queue Method.
    public static int minDepth(LeafNode root) {
        if(root == null) return 0;

        int depth = 0;

        return depth;
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
