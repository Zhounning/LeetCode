package leetCode;
/**
 * RemoveNthFromEnd
 * 2020-07-04   重写
 */
public class removeNthFromEnd {

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

    public ListNode RemoveNthFromEnd(ListNode head, int n) {
       ListNode p = head;
       ListNode PreremoveNode = null;
       while (p!=null) {
           p = p.next;
          

           if (PreremoveNode!=null) {
                PreremoveNode=PreremoveNode.next;  
           }

           if (n==0) {
               PreremoveNode = head;
           }
           n--;
       }

       if (PreremoveNode!=null){
           ListNode removeNode =PreremoveNode.next;
           PreremoveNode.next = removeNode.next;
           removeNode.next = null;
       }else{

           ListNode removeNode = head;
           head = head.next;
           removeNode.next = null;
       }

       return head;
    }
}