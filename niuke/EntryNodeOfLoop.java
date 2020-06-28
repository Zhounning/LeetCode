package niuke;

import java.util.List;

public class EntryNodeOfLoop {
    
    public ListNode entryNodeOfLoop(ListNode pHead)
    {
        ListNode meetNode = MeetingNode(pHead);
        if (meetNode==null) {
            return null;
        }

        int nodeInLoop = 1;
        ListNode pNode1 = meetNode;
        while (pNode1.next!=meetNode) {
            pNode1=pNode1.next;
            ++nodeInLoop;
        }

        pNode1 = pHead;
        for (int i = 0; i < nodeInLoop; i++) {
            pNode1 = pNode1.next;
        }

        ListNode pNode2 = pHead;
        while (pNode1!=pNode2) {
            pNode1=pNode1.next;
            pNode2=pNode2.next;
        }

        return pNode1;
    }

    private ListNode MeetingNode(ListNode pHead){
        if (pHead==null) {
            return null;
        }

        ListNode pSlow = pHead.next;
        if (pSlow==null) {
            return null;
        }

        ListNode pFast = pSlow.next;
        while (pFast!=null && pSlow!=null) {
            if (pFast==pSlow) {
                return pFast;
            }

            pSlow = pSlow.next;
            pFast = pFast.next;
            if (pFast!=null) {
                pFast=pFast.next;
            }
        }
        return null;
    }
    
}