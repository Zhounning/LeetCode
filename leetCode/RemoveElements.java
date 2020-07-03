package leetCode;
/**
 * RemoveElements
 */
public class RemoveElements {

    // 删除链表中等于给定值 val 的所有节点。

    // 示例:

    // 输入: 1->2->6->3->4->5->6, val = 6
    // 输出: 1->2->3->4->5

    public ListNode removeElements(ListNode head, int val) {
        
        while (head!=null&&head.val==val) {
            ListNode temp = head;
            head = head.next;
            temp.next =null;
        }

        ListNode cur = head;
        ListNode last = null;
     
        while (cur!=null) {

            if(cur.val==val){
                
                last.next = cur.next;
                cur.next = null;
                cur =last.next;
            }else{
                last = cur;
                cur = cur.next;
            }

        }
        return head;
    }
    
}


