package leetCode;

/**
 * reverseBetween
 */
public class reverseBetween {
    //1->2->3->4->5->NULL
    public ListNode ReverseBetween(ListNode head, int m, int n) {
        if (head==null) {
            return null;
        }
        //哑节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        //p1为 m的前一个节点
        ListNode p1 = dummy;
        // m代表的节点
        ListNode mNode = head;
        //n代表的节点
        ListNode NNode = head;

        // p2 为n之后的节点
        ListNode p2 = head;

        int i = 0;
        while (true) {
            i++;
            if (i==m-1) {
                p1 = NNode;
            }

            if (i==m) {
                mNode = NNode;
            }
            if (i==n) {
                break;
            }
            NNode = NNode.next;
        }
        p2 = NNode.next;
        NNode.next = null;

        //将 m 到 n节点进行翻转
        p1.next = reverseList(mNode);
        mNode.next = p2;
        return dummy.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode lastNode = null;
        ListNode nextNode = head.next;    

        while (cur!=null) {
            cur.next = lastNode;
            lastNode = cur;
            cur = nextNode;
            if(nextNode!=null)
            nextNode = nextNode.next;
        }

        return lastNode;
    }

    public static void main(String[] args) {
        reverseBetween r = new  reverseBetween();
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        // b.next=c;c.next=d;d.next=e;
        int m=2;
        int n=2;
        ListNode p = r.ReverseBetween(a, m, n);
        while (p!=null) {
            System.out.println(p.val);
            p=p.next;
        }
    }

}