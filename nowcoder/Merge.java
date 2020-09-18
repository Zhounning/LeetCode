package nowcoder;

public class Merge {
    public ListNode merge(ListNode list1,ListNode list2) {
        if (list1==null&&list2==null) { return null;}
        if (list1==null) {return list2;}
        if(list2==null){return list1;}

        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode p3 = null;
        ListNode newHead = null;
        while (p1!=null&&p2!=null) {
            
            if (p3!=null){
                if (p1.val>p2.val) {
                    p3.next = p2;
                    p2 = p2.next;
                }else{
                    p3.next = p1;
                    p1=p1.next;
                }
                p3 = p3.next;

            } else {
                if (p1.val>p2.val) {
                    p3 = p2;
                    p2 = p2.next;
                }else{
                    p3= p1;
                    p1=p1.next;
                }
                newHead = p3;
            }

        }

        ListNode p = p1==null? p2: p1;
        //得到头节点
        // while (p!=null) {
        //     p3.next = p;
        //     p = p.next;
        //     p3 = p3.next;
        // }
        p3.next = p;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode p11 = new ListNode(3);
        ListNode p12 = new ListNode(10);
        ListNode p13 = new ListNode(20);
        list1.next = p11;p11.next = p12;p12.next = p13;

        ListNode list2 = new ListNode(4);
        ListNode p21 = new ListNode(5);
        ListNode p22 = new ListNode(6);
        ListNode p23 = new ListNode(7);
        list2.next = p21;p21.next = p22;p22.next = p23;
        Merge merge = new Merge();
        merge.merge(list1, list2);
    }
}