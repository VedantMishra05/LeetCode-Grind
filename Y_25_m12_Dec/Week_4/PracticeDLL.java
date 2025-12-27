package Y_25_m12_Dec.Week_4;

public class PracticeDLL {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
        Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    public int getsize() {
        return size;
    }
    public int gethead() {
        if(head == null) throw new IllegalStateException("List is empty.");
        return head.data;
    }
    public int getTail() {
        if(tail == null) throw new IllegalStateException("List is empty.");
        return tail.data;
    }

    void insertFirst(int value) {
        if(head == null) {
            Node n = new Node(value);
            head = tail = n;
            size++;
            return;
        }
        Node n = new Node(value, head, null);
        head.prev = n;
        head = n;
        size++;
    }
    void insertLast(int value) {
        if(tail == null) { insertFirst(value); return;}
        Node n = new Node(value, null, tail);
        tail.next = n;
        tail = n;
        size++;
    }
    void insertAtPosition(int value, int position) {
        if(position < 0 || position > size) { System.out.println("Invalid Position"); return;}
        if(position == 0) { insertFirst(value); return;}
        if(position == size) { insertLast(value); return;}
        Node temp = head;
        for(int i = 0; i < position - 1; i++) temp = temp.next;
        Node n = new Node(value, temp.next, temp);
        temp.next.prev = n;
        temp.next = n;
        size++;
    }

    void removeFirst() {
        if(head == null) { System.out.println("Invalid request: List is empty"); return;}
        if(head.next == null) { System.out.println("Removed " + head.data); head = tail = null; size--; return;}
        System.out.println("Removed " + head.data);
        head.next.prev = null;
        head = head.next;
        size--;
    }
    void removeLast() {
        if(tail == null) { System.out.println("Invalid request: List is empty"); return;}
        if(tail.prev == null) { System.out.println("Removed " + tail.data); head = tail = null; size--; return;}
        System.out.println("Removed " + tail.data);
        tail = tail.prev;
        tail.next = null;
        size--;
    }
    void removeAtPosition(int position) {
        if(position < 0 || position > size - 1) { System.out.println("Invalid input. Please provide a valid position"); return;}
        if(position == 0) { removeFirst(); return;}
        if(position == size - 1) { removeLast(); return;}
        Node temp = head;
        for(int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        System.out.println("Removed " + temp.next.data + " at index " + position);
        temp.next = temp.next.next;
        temp.next.prev = temp;
        size--;
    }
    void remove(int value) {
        if(head == null) { System.out.println("Invalid request: List is empty"); return;}
        if(head == tail) {
            head = (head.next == null && head.data == value) ? null : head;
            tail = (head == null) ? null : tail;
            return;
        }
        
    }

    public void toStringForward() {
        if(head == null) { System.out.println("List is empty!"); return;}
        if(head.next == null) { System.out.println(head.data + "(head, tail)"); return;}
        Node temp = head;
        while(temp != null) {
            if(temp == head) System.out.print(temp.data + "(head) <=> ");
            else if(temp.next == null) System.out.print(temp.data + "(tail)");
            else {
                System.out.print(temp.data + " <=> ");
            }
            temp = temp.next;
        }
        System.out.println();
        System.out.println();
    }
    public void toStringBackward() {
        if(tail == null) { System.out.println("List is empty!"); return;}
        if(tail.prev == null) { System.out.println(tail.data + "(head, tail)"); return;}
        Node temp = tail;
        while(temp != null) {
            if(temp == tail) System.out.print(temp.data + "(tail) <=> ");
            else if(temp.prev == null) System.out.print(temp.data + "(head)");
            else {
                System.out.print(temp.data + " <=> ");
            }
            temp = temp.prev;
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        PracticeDLL list = new PracticeDLL();
        // list.insertFirst(3);
        // list.insertFirst(2);
        // list.insertFirst(1);
        
        // list.insertLast(1);
        // list.insertLast(2);
        // list.insertLast(3);


        list.insertAtPosition(1, 0);
        list.insertAtPosition(2, 1);
        list.insertAtPosition(3, 2);
        list.insertAtPosition(4, 3);
        list.insertAtPosition(5, 4);
        list.toStringForward();
        
        // list.removeFirst();
        // list.toStringForward();
        
        // list.removeLast();
        // list.toStringForward();
        
        // list.removeAtPosition(2);
        // list.toStringForward();
        
        list.remove(2);
        list.toStringForward();
    }
}
