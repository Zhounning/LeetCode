package leetCode;
/**
 * AddTwoNumbers
 */
/**
  Definition for singly-linked list.
  */
   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 


public class AddTwoNumbers {

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode cur = null;
        int a = 0;//相加之后的值
        int b = 0;//相加之后的进位，所以为1或者0

        //先将两者共同部分相加
        while(l1!=null&&l2!=null){
            a = (l1.val+l2.val + b) % 10;
            b = (l1.val+l2.val + b) / 10;
            //进行链表的连接
            ListNode newNode = new ListNode(a);
            if(res==null){
                res = newNode;
                cur = newNode;
            }else{
                cur.next = newNode;
                cur = newNode;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        //将两者剩余部分相加,剩下部分最多是一条链表
        ListNode p = l1!=null? l1 : l2;

        while(p!=null){
            a = (p.val + b) % 10;
            b = (p.val + b) / 10;
            //进行链表的连接
            ListNode newNode = new ListNode(a);
            if(res==null){
                res = newNode;
                cur = newNode;
            }else{
                cur.next = newNode;
                cur = newNode;
            }

            p=p.next;
        }
        //最后需要判断b是否为1，如果为1需要加一个节点
        if(b==1){
            ListNode newNode = new ListNode(1);
            cur.next = newNode;
            cur = newNode;
        }

        return res;
    }

    public static void main(String[] args) {
        
    }
}