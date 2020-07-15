package leetCode;

public class deleteDuplicates {
    public ListNode DeleteDuplicates(ListNode head) {
        if(head==null)return null;
        if(head.next==null)return head;
        ListNode curent = head;
        ListNode next = head.next;

        while (next!=null) {
            if (curent.val==next.val) {
                //如果 curent = next
                while(next!=null && curent.val==next.val) {
                    next = next.next;
                }
                curent.next = next;
                curent = next;
                if(next!=null) next =next.next;
            }else{
                curent = next;
                next = next.next;
            }    
        }

        return head;
    }


    public static void main(String[] args) {
        deleteDuplicates de =new deleteDuplicates();
        ListNode head  = new ListNode(1);
        ListNode a  = new ListNode(1);
        ListNode b  = new ListNode(2);
        ListNode c  = new ListNode(3);
        ListNode d  = new ListNode(3);
        ListNode e  = new ListNode(4);
        ListNode f  = new ListNode(5);
        head.next = a;a.next=b;
        b.next=c;c.next=d;
        // d.next=e;e.next=f;
        ListNode p = de.DeleteDuplicates(head);
        while (p!=null) {
            System.out.println(p.val);
            p=p.next;
        }
    }
}