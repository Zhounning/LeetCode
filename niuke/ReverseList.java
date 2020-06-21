package niuke;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head==null) {
            return null;
        }
        ListNode current = head;
        ListNode lastnode = null;
        ListNode nextnode = head.next;

        while (current!=null) {
            //指针变化
            current.next = lastnode;

            lastnode = current;
            current = nextnode;
            if (nextnode!=null) {
                nextnode = nextnode.next;
            }
        }
        return lastnode;
    }
}