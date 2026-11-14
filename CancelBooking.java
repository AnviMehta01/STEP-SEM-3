package week12assignment;


class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class CancelBooking {

    static Node removeFirst(Node head, String booking) {

        if (head == null) {
            System.out.println(booking + " not found");
            return head;
        }

        if (head.data.equals(booking)) {
            return head.next;
        }

        Node temp = head;

        while (temp.next != null) {
            if (temp.next.data.equals(booking)) {
                temp.next = temp.next.next;
                return head;
            }

            temp = temp.next;
        }

        System.out.println(booking + " not found");
        return head;
    }

    static void display(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node("104");
        head.next = new Node("101");
        head.next.next = new Node("107");
        head.next.next.next = new Node("101");

        head = removeFirst(head, "101");

        display(head);
    }
}

