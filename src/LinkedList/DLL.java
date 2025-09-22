package LinkedList;

public class DLL {
    private Node head;

    public void insertFirst(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            head.prev = null;
        } else {
            node.next = head;
            head.prev = node;
            node.prev = null;
            head = node;
        }
    }

    public void display() {
        Node node = head;
        Node last = null;

        System.out.print("Forward: ");
        while (node != null) {
            System.out.print(node.value + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");


        System.out.print("Reverse: ");
        while (last != null) {
            System.out.print(last.value + " <- ");
            last = last.prev;
        }
        System.out.println("START");
    }

    private class Node{
        private int value;
        private Node prev;
        private Node next;

        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
        public  Node(int value){
            this.value = value;
        }
    }

}
