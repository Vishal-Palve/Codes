package LinkedList;

public class LL {
     private Node head;
     private Node tail;
     private int size;
     public LL(){
         this.size = 0;
     }
      public void insertFirst(int val){
         Node node = new Node(val);
         node.next = head;
         head = node;

         if(tail == null){
             tail = head;
         }
         size++;
      }
    public void insertEnd(int val){
         Node node = new Node(val);
         if(tail == null){
             insertFirst(val);
             return;
         }
         tail.next = node;
         tail = node;
         size++;
    }
    public void insert(int val, int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertEnd(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty, nothing to delete");
            return;
        }
        if (head.next == null) {
            head = null;
            size--;
            return;
        }
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        temp.next = null;
        size--;
    }

    public void deletion(int index){
         Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }
    public int deleteFirst(){
         int val = head.value;
         head = head.next;
         if(head == null){
             tail = null;
         }
         size--;
         return val;
    }
    public void display(){
         Node temp = head;
         while(temp !=null){
             System.out.print(temp.value +" -> ");
             temp = temp.next;
         }
         System.out.println("END");
     }
     public Node get(int index){
         Node node = head;
         for (int i = 0; i < index; i++) {
            node = node.next;
         }
         return node;
     }

    public Node find(int val){
        Node node = head;
        while(node != null){
            if(node.value == val){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Node reverseLL(){
         if(head == null || head.next == null){
             return head;
         }
         Node prev = null;
         Node curr = head;

         while(curr != null){
             Node next = curr.next;
             curr.next = prev;
             prev = curr;
             curr = next;
         }
         return prev;
    }
    public class Node{
        private int value;
        private Node next;
        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
