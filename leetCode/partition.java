package leetCode;

/**
 * Partition 2020-07-15 重做
 */
public class partition {

    public ListNode Partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        // 多加一个指针，方便后续操作
        ListNode first = new ListNode(x);
        first.next = head;
        // 添加快排操作
        ListNode pivtpos = first;
        ListNode pre = first;
        ListNode p = first.next;
        while (p != null) {

            if (p.val < first.val) {
                if (pre != pivtpos) {
                    // 指针交换
                    pre.next = p.next;
                    p.next = pivtpos.next;
                    pivtpos.next = p;

                    p = pre.next;
                } else {
                    pre = pre.next;
                    p = p.next;
                }
                pivtpos = pivtpos.next;

            } else {
                pre = pre.next;
                p = p.next;
            }

        }

        head = first.next;
        first.next = null;
        return head;
    }

    public static void main(String[] args) {
        partition pa = new partition();
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(2);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode p = pa.Partition(head, 3);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}