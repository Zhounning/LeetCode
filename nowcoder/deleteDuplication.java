
package nowcoder;

import sun.security.krb5.internal.LastReqEntry;

public class deleteDuplication {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead==null) {
            return null;
        }

        ListNode lastNode = null;
        ListNode p =pHead;
        ListNode nextNode = p.next;
        boolean isDuplicated = false;
        while (p!=null && nextNode!=null) {
            
            while (nextNode!=null&&p.val==nextNode.val) {
                nextNode=nextNode.next;
                isDuplicated =true;
            }

            if (isDuplicated) {
                   //进行指针的处理
                if ( lastNode!=null) {
                    lastNode.next = nextNode;
                }else{
                    pHead = nextNode;
                    // lastNode = nextNode;
                }
                isDuplicated = false;
            }else{
                lastNode = p;  
            }

            p = nextNode;
            if (nextNode!=null) {
                nextNode =nextNode.next;    
            }
        }

        return pHead;
    }

    public static void main(String[] args) {
        ListNode pHead = new ListNode(1);    
        ListNode p1 = new ListNode(1);    

    }
}