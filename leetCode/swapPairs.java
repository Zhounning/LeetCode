package leetCode;
/**
 * SwapPairs
 * 2020-07-05 重做
 */
public class swapPairs {
    // 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

    // 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
    
    //  
    
    // 示例:
    
    // 给定 1->2->3->4, 你应该返回 2->1->4->3.
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    //递归完成
    public ListNode SwapPairs(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }

        ListNode firstNode = head;
        ListNode secondNode = head.next;


         // 进行交换
         firstNode.next  = SwapPairs(secondNode.next);
         secondNode.next = firstNode;
 
         // 返回
         return secondNode;
    }
}