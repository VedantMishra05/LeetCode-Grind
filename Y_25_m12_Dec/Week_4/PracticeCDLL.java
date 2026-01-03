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

    public int getHead() {
        if(head == null) throw new IllegalStateException("List is empty.");
        return head.data;
    }
    
    public int getTail() {
        if(tail == null) throw new IllegalStateException("List is empty.");
        return tail.data;
    }
    
    public int getSize() {
        return size;
    }

    void insertFirst(int val) {
        if(head == null) { head = tail = new Node(val); return;}
        Node node = new Node(val, head, tail);
        tail.next = node;
        head.prev = node;
        head = node;
        size++;
    }

    void insertLast(int val) {
        if(head == null) { head = tail = new Node(val); return;}
        Node node = new Node(val, head, tail);
        tail.next = node;
        head.prev = node;
        tail = node;
        size++;
    }
    
    void insertAtPosition(int val, int pos) {

    }
    
    void removeFirst() {}
    
    void removeLast() {}
    
    void removeAtPosition(int pos) {}
    
    void remove(int val) {}
    
    void displayForward() {
        if(head == null) throw new IllegalStateException("List is empty !!!");
        Node temp = head;
        System.out.println();
        do {
            if(temp == head) System.out.print("(tail) <=> " + temp.data + "(head) <=> ");
            else if(temp == tail) System.out.print(temp.data + "(tail) <=> (head)");
            else System.out.print(temp.data + " <=> ");
            temp = temp.next;
        }while(temp != head);
        System.out.println();
        System.out.println();
    }
    
    void displayBackward() {
        if(tail == null) throw new IllegalStateException("List is empty.");
        Node temp = tail;
        System.out.println();
        do {
            if(temp == head) System.out.print(temp.data + "(head) <=> (tail)");
            else if(temp == tail) System.out.print("(head) <=> " + temp.data + "(tail) <=> ");
            else System.out.print(temp.data + " <=> ");
            temp = temp.prev;
        }while(temp != tail);
        System.out.println();
        System.out.println();
    }
    
    void rotateLeft() {
        if(head == null) throw new IllegalStateException("List is empty !!!");
        head = head.next;
        tail = tail.next;
    }
    
    void rotateRight() {
        if(head == null) throw new IllegalStateException("List is empty !!!");
        head = head.prev;
        tail = tail.prev;
    }
    
    void clear() {
        head = tail = null;
        size = 0;
    }
    
    public static void main(String[] args) {
        PracticeCDLL list = new PracticeCDLL();
        list.insertFirst(2);
        list.insertFirst(1);
        list.insertLast(3);
        list.insertLast(4);

        list.displayForward();
        list.displayBackward();
    }
}
