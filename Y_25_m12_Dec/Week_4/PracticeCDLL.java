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
}
