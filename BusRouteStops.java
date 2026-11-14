package week12assignment;


class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class BusRouteStops {

    static Node build(String[] stops) {
        Node head = null, tail = null;

        for (String stop : stops) {
            Node newNode = new Node(stop);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }

    static void printRoute(Node head) {
        Node temp = head;
        int count = 0;
        String first = null, last = null;

        while (temp != null) {
            if (count == 0)
                first = temp.data;

            last = temp.data;
            System.out.print(temp.data + " -> ");
            count++;
            temp = temp.next;
        }

        System.out.println("null");
        System.out.println("Stops: " + count +
                ", First: " + first + ", Last: " + last);
    }

    public static void main(String[] args) {
        String[] stops = {"Tambaram", "Guindy", "TNagar", "Central"};

        Node head = build(stops);
        printRoute(head);
    }
}

