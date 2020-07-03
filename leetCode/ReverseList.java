package leetCode;
/**
 * ReverseList
 */
public class ReverseList {

    // 反转一个单链表。

    // 示例:

    // 输入: 1->2->3->4->5->NULL
    // 输出: 5->4->3->2->1->NULL

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
}

