package nowcoder;

/**
 * FindKthToTail
 */
public class FindKthToTail {

    public ListNode findKthToTail(ListNode head,int k) {
            if (head==null) {return null;}
            //开始的指针
            ListNode p1 = head;
            //后面的指针
            ListNode p2 = null;
            //p1开始走的次数
            int count=0;
            while (p1!=null){
                p1=p1.next;
                count++; 
                if (p2!=null) {
                    p2=p2.next;
                }
                
                if (count==k) {
                    p2 = head;
                }
               
            }
            return p2;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p1 = new ListNode(2);
        ListNode p2 = new ListNode(3);
        ListNode p3 = new ListNode(4);
        ListNode p4 = new ListNode(5);
        head.next = p1;p1.next = p2;p2.next = p3;p3.next = p4;
        FindKthToTail findKthToTail = new FindKthToTail();
        ListNode res = findKthToTail.findKthToTail(head, 1);
        System.out.println(res.val);

    }
}