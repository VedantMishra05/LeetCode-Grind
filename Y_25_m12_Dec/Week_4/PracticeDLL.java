package Y_25_m12_Dec.Week_4;

public class PracticeDLL {
    private static Node HEAD = null;
    private static Node TAIL = null;
    private static int SIZE = 0;

    class Node {
        int data;
        Node next;
        Node prev;

        Node() {

        }
        Node(int data) {
            this.data = data;
        }
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
        Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    public int getSize() {
        return SIZE;
    }
    public int getHead() {
        return HEAD.data;
    }
    public int getTail() {
        return TAIL.data;
    }

    void insertFirst() {}
    void insertLast() {}
    void insertAtPosition() {}

    void removeFirst() {}
    void removeLast() {}
    void removeAtPosition() {}

    public String toStringForward() {
        
        return "";
    }
    public String toStringBackward() {
        
        return "";
    }
}
