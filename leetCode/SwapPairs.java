package leetCode;
/**
 * SwapPairs
 */
public class SwapPairs {
    // 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

    // 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
    
    //  
    
    // 示例:
    
    // 给定 1->2->3->4, 你应该返回 2->1->4->3.
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public ListNode swapPairs(ListNode head) {
        if(head==null)
        return null;

        //因为是两两进行交换，所以一定是偶数个
        ListNode p1last = null;
        ListNode p1 = head;
        ListNode p2 = p1.next;
        ListNode p2next = p2.next;

        while(p2next!=null){
           //交换
            p2.next = p1;
            if(p1last!=null)
                p1last.next = p2;
            else
                head = p2;

            p1 = p2next;
            p2 = p1.next;
            p2next = p2.next;
            p1last = p1;
        }

        //因为在p2next=null就出来了，所以还需要进行一次交换
        p2.next = p1;
        if(p1last!=null)
            p1last.next = p2;
        else
            head = p2;
        
        return head;

    }
}