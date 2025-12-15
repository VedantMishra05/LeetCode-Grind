package Dec25.Week_3;
class Node {
    int val;
    Node next;

    Node(int x) {
        this.val = x;
        this.next = null;
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
