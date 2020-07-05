package leetCode;

/**
 * reverseKGroup
 */
public class reverseKGroup {

    public ListNode ReverseKGroup(ListNode head, int k) {
        if (head==null) return null;
        
        int length = 0;
        ListNode p =head;
        while (p!=null && length<k) {
            p=p.next;
            ++length;
        }

        if (length<k || length==1) {
            return head;
        }

        p=head;
        ListNode lastNode = null;
        ListNode nextNode = head.next;
        length = 0;
        while (length<k) {
            p.next = lastNode;
            lastNode = p;
            p = nextNode;
            if(nextNode!=null)
            nextNode = nextNode.next;
            length++;
        }

        head.next = ReverseKGroup(p, k);
        return lastNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p =head;
        for (int i = 2; i <=2; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }

        reverseKGroup r =new reverseKGroup();
        p = r.ReverseKGroup(head, 2);
        while (p!=null) {
            System.out.println(p.val);
            p=p.next;
        }
    }
}