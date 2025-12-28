package Y_25_m12_Dec.Week_4;

public class PracticeCDLL {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    class Node {
        int data;
        Node next = null;
        Node prev = null;

        Node(int data) {
            this.data = data;
        }
    }

    public int getHead() {
        if(head == null) return 0;
        return head.data;
    }
    
    public int getTail() {
        if(tail == null) return 0;
        return tail.data;
    }
    
    public int getSize() {
        return size;
    }
}
