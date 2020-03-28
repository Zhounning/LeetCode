/**
 * Partition
 */
public class Partition {
    // 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

    // 你应当保留两个分区中每个节点的初始相对位置。
    
    // 示例:
    
    // 输入: head = 1->4->3->2->5->2, x = 3
    // 输出: 1->2->2->4->3->5
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/partition-list
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public ListNode partition(ListNode head, int x) {
        //有点类似于快排，但是可以利用快排的原理进行插入
        if(head==null)
            return null;

        //使用双指针
        ListNode prePiv = null;
        ListNode pivotpos = head;
        ListNode preCur =  null;
        ListNode current = head;

        while (current!=null){

            if (current.val<x) {
                
                if(current==pivotpos){
                    prePiv = pivotpos;
                    pivotpos = pivotpos.next;
                }else{

                    //进行交换
                    preCur.next  = current.next;

                    if(prePiv!=null)    //说明不是头节点
                        prePiv.next = current;
                    else{
                        //说明是头节点
                        head = current;
                    }  
                    current.next = pivotpos;

                    prePiv = current;
                    current = preCur;
                }
            }

            preCur = current;
            current =current.next;
        }
        

        return head;
    }
}