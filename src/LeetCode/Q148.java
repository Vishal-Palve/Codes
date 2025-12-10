package LeetCode;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
    ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Q148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    public ListNode merge(ListNode head1, ListNode head2) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val > head2.val) {
                tail.next = head2;
                head2.next = head1;
                tail = head2.next;
            } else {
                tail.next = head1;
                head1.next = head2;
                tail = head1.next;
            }
        }
        if (head1 != null) {
            tail.next = head1;
        }
        if (head2 != null) {
            tail.next = head2;
        }

        return dummy.next;
    }


    public ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
