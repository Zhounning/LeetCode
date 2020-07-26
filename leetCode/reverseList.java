
package leetCode;

/**
 * reverseList
 */
public class reverseList {
    //迭代法
    public ListNode ReverseList(ListNode head) {
        ListNode cur = head;
        ListNode lastNode = null;
        ListNode nextNode = null;    

        while (cur!=null) {
            nextNode = cur.next;
            cur.next = lastNode;
            lastNode = cur;
            cur = nextNode;
        }

        return lastNode;
    }

    //递归法
    public ListNode ReverseList2(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode p = ReverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;

    }
}