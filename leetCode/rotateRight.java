package leetCode;

public class rotateRight {
    public ListNode RotateRight(ListNode head, int k) {
        // 基本清理
        if (head == null) return null;
        if (head.next == null) return head;

        // 将链表形成环
        ListNode old_tail = head;
        int n;
        for(n = 1; old_tail.next != null; n++)
        old_tail = old_tail.next;
        old_tail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++)
        new_tail = new_tail.next;
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;

    }

    public static void main(String[] args) {
        rotateRight r =new rotateRight();
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        // head.next=a;a.next=b;
        // b.next=c;c.next=d;
        int k=1;
        ListNode h = r.RotateRight(head, k);
        while (h!=null) {
            System.out.println(h.val);
            h=h.next;
        }
    }
}