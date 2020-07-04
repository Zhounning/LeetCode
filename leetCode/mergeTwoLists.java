package leetCode;

public class mergeTwoLists {
    public ListNode MergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null && l2==null) {
            return null;
        }
        ListNode p1 =l1;
        ListNode p2 =l2;
        ListNode head = null;
        ListNode p3 =null;
        while (p1!=null || p2!=null) {
            int v1 = p1==null?Integer.MAX_VALUE:p1.val;
            int v2 = p2==null?Integer.MAX_VALUE:p2.val;
            
            if(head==null){
                if (v1<v2) {
                    head = p1;
                    p1=p1.next;
                }else{
                    head=p2;
                    p2=p2.next;
                }
                p3 = head;
            }else{
                if (v1<v2) {
                    p3.next = p1;
                    p1=p1.next;
                }else{
                    p3.next=p2;
                    p2=p2.next;
                }
                p3 = p3.next;
            }

        }

        return head;

    }
}