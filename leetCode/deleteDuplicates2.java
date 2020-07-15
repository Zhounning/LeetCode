package leetCode;

public class deleteDuplicates2 {
    //排序这个条件确保了重复的的元素会相连
    public ListNode DeleteDuplicates(ListNode head) {
        if(head==null)return null;
        if(head.next==null)return head;
        ListNode last = null;
        ListNode curent = head;
        ListNode next = head.next;
        ListNode newHead = null;

        while (next!=null) {
            if (curent.val==next.val) {
            //如果 curent = next

                while(next!=null && curent.val==next.val) {
                    curent = curent.next;
                    next = next.next;
                }
                //需要判断 last,如果等于null 
                //说明从头开始就重复，如 1->1->1->2->2->3
                if (last!=null) {
                    last.next = next;
                }
                curent.next = null;
                curent = next;
                if(next!=null) next =next.next;
                if (next==null &&newHead==null ) {
                    newHead = curent;
                }
            }else{
                //不相等
                last = curent;
                curent = next;
                next = next.next;
                if (newHead==null) {
                    newHead = last;
                }
            }
        }
        return newHead;
    }


    public static void main(String[] args) {
        deleteDuplicates2 de =new deleteDuplicates2();
        ListNode head  = new ListNode(1);
        ListNode a  = new ListNode(1);
        ListNode b  = new ListNode(2);
        ListNode c  = new ListNode(3);
        ListNode d  = new ListNode(4);
        ListNode e  = new ListNode(4);
        ListNode f  = new ListNode(5);
        head.next = a;a.next=b;
        // b.next=c;c.next=d;
        // d.next=e;e.next=f;
        ListNode p = de.DeleteDuplicates(head);
        while (p!=null) {
            System.out.println(p.val);
            p=p.next;
        }

    }
}