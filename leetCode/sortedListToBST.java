package leetCode;

public class sortedListToBST {
    // 用两个指针，一块一慢，快的每次走两步，慢的每次走一步，
    // 这样当快指针遍历结束时，慢指针指向的也就是链表的中间位置。这时候把中间位置的结点的值作为二叉搜索树当前结点的值
    public TreeNode SortedListToBST(ListNode head) {
        TreeNode root=null;
        if (head==null) {
            return root;
        }
        if (head.next==null){
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;

        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow=slow.next;
        }

        while (pre.next!=slow) {
            pre = pre.next;
        }
        root = new TreeNode(slow.val);
        pre.next = null;
        root.left = SortedListToBST(head);
        root.right = SortedListToBST(slow.next);
        return root;
    }
}