package Y_25_m12_Dec.Week_4;

// Take you forward..
public class PracticeLinkedList {
    private Node HEAD = null;
    private Node TAIL = null;
    private int SIZE = 0;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public int getSize() {
        return SIZE;
    }
    public int getHead() {
        if(HEAD == null) throw new IllegalStateException("List is empty.");
        return HEAD.data;
    }
    public int getTail() {
        if(TAIL == null) throw new IllegalStateException("List is empty.");
        return TAIL.data;
    }

    void insertLast(int value) {
        if (HEAD == null) {
            insertFirst(value);
            return;
        }
        TAIL.next = new Node(value);
        TAIL = TAIL.next;
        SIZE++;
    }

    void insertFirst(int value) {
        if (HEAD == null) {
            HEAD = TAIL = new Node(value);
            SIZE++;
            return;
        }
        Node temp = new Node(value);
        temp.next = HEAD;
        HEAD = temp;
        SIZE++;
    }

    void insertAtPosition(int value, int position) {
        if (position == 0) {
            insertFirst(value);
            return;
        }
        if (position < 0 || position > SIZE) {
            System.out.println("Invalid Request");
            return;
        }
        if (SIZE == position) {
            insertLast(value);
            return;
        }

        Node temp = HEAD;
        int count = 0;
        while (count < position - 1) {
            temp = temp.next;
            count++;
        }
        Node n = new Node(value);
        n.next = temp.next;
        temp.next = n;
        SIZE++;
    }

    void removeLast() {
        if (HEAD == null) {
            System.out.println("Invalid request");
            return;
        }
        if (HEAD.next == null) {
            System.out.println("Removed head '" + HEAD.data + "' of the list.");
            HEAD = TAIL = null;
            SIZE--;
            return;
        }
        Node temp = HEAD;
        while (temp.next.next != null) temp = temp.next;
        System.out.println("Removed " + temp.next.data + " from the list.");
        temp.next = null;
        TAIL = temp;
        SIZE--;

        this.toString();
    }

    void removeFirst() {
        if (HEAD == null) {
            System.out.println("Invalid request");
            return;
        }
        if (HEAD.next == null) {
            System.out.println("Removed head '" + HEAD.data + "' of the list.");
            HEAD = null;
            SIZE--;
            return;
        }
        System.out.println("Removed " + HEAD.data + " from the list.");
        HEAD = HEAD.next;
        SIZE--;

        this.toString();
    }

    void remove(int value) {
        if(HEAD == null) { System.out.println("List is empty!"); return;}
        if(HEAD.data == value) { removeFirst(); return;}
        if(TAIL.data == value) { removeLast(); return;}
        Node temp = HEAD;
        while(temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }
        if(temp.next != null) {
            System.out.println("Removed " + temp.next.data + " from the list.");
            temp.next = temp.next.next;
            SIZE--;
            toString();
        } else {
            System.out.println(value + " not found in the list");
        }
    }

    void removeAtPosition(int position) {
        if (HEAD == null) {System.out.println("List is empty"); return;}
        if (position < 0 || position > SIZE - 1) {
            System.out.println("Invalid Position");
            return;
        }
        if(position == 0) { removeFirst(); return;}
        if (position == SIZE - 1) { removeLast(); return;}
        Node temp = HEAD;
        for(int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        System.out.println("Removed " + temp.next.data + " from the list.");
        temp.next = temp.next.next;
        toString();
        SIZE--;
    }

    public void convert(int[] arr) {
        HEAD = TAIL = null;
        SIZE = 0;
        for(int x: arr) insertLast(x);
    }

    @Override
    public String toString() {
        Node temp = HEAD;
        while (temp != null) {
            if(temp == HEAD) System.out.print(temp.data + " (HEAD) -> ");
            else if (temp.next == null) System.out.print(temp.data + " (TAIL)"); // else if isliye jab tail = head;
            else System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
        System.out.println("The size of the current list is: " + SIZE);
        System.out.println();
        return super.toString();
    }

    public static void main(String[] args) {
        // int[] arr = {1, 2, 3, 4, 5};
        // displayLL(convert(arr));

        PracticeLinkedList list = new PracticeLinkedList();
        list.insertFirst(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertFirst(0);
        list.insertLast(5);
        list.insertAtPosition(4, 4);
        list.toString();

        list.removeFirst();
        
        list.removeLast();
    }
}
