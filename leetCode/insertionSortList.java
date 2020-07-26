package leetCode;

public class insertionSortList {
    public ListNode InsertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur!=null) {
            //默认从dummy到pre为有序
            if (cur.val<pre.val) {
                //从前向后找，找到合适的位置进行插入
                ListNode p = dummy;

                while (p.next.val<cur.val) {
                    p=p.next;
                }
                //将 cur插入到合适位置
                pre.next = cur.next;
                cur.next = p.next;
                p.next = cur;
                cur = pre.next;

            }else{
                cur = cur.next;
                pre= pre.next;
            }

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        
    }
}