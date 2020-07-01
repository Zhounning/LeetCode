package leetCode;
/**
 * RemoveNthFromEnd
 */
public class RemoveNthFromEnd {

    // 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

    // 示例：
    
    // 给定一个链表: 1->2->3->4->5, 和 n = 2.
    
    // 当删除了倒数第二个节点后，链表变为 1->2->3->5.
    // 说明：
    
    // 给定的 n 保证是有效的。
    
    // 进阶：
    
    // 你能尝试使用一趟扫描实现吗？
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null) {
            return null;
        }

        
        ListNode p1 = head;
        ListNode p2 = null; //需要删除的指针
        ListNode p3 = null;
        //使用双指针，其实是一个快慢指针，让你理解倒数这个概念

        int i=0;
        while (p1!=null) {
            if(i==n) p2 = head;

            p1 = p1.next;

            if (p2!=null) {
                p3 = p2;
                p2 = p2.next;
            }
            i++;
        }

        //说明没有到最后一个还没有到p2，所以删除头节点
        if(i<n){
            p2 = head;
            head = head.next;
            p2.next = null;
        }else{
            //按照正常的删除,需要删除p2
            p3.next = p2.next;
            p2.next = null;
        }

        return head;

    }
}