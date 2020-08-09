package leetCode;

/**
 * SwapPairs 2020-07-05 重做
 */
public class swapPairs {
    // 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

    // 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

    //  

    // 示例:

    // 给定 1->2->3->4, 你应该返回 2->1->4->3.

    // 递归完成
    public ListNode SwapPairs(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // 进行交换
        firstNode.next = SwapPairs(secondNode.next);
        secondNode.next = firstNode;

        // 返回
        return secondNode;
    }

    /****
     * 迭代完成
     * 
     * @param head
     * @return
     */
    public ListNode SwapPairs2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preNode = dummy;
        ListNode firstNode = head;
        ListNode secondNode = head;

        while (firstNode != null && firstNode.next != null) {
            secondNode = firstNode.next;

            preNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            preNode = firstNode;
            firstNode = firstNode.next;

        }
        return dummy.next;
    }
}