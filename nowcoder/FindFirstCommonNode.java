package nowcoder;

public class FindFirstCommonNode {
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            int length1 = getListLength(pHead1);
            int length2 = getListLength(pHead2);
            int lengthDif = length1 - length2;

            ListNode pLong = pHead1;
            ListNode pShort = pHead2;

            if (length2>length1) {
                pLong = pHead2;
                pShort = pHead1;
                lengthDif = length2 -length1;
            }

            for (int i = 0; i < lengthDif; i++) {
                pLong = pLong.next;
            }

            while (pLong!=null && pShort!=null && pLong!=pShort) {
                pLong = pLong.next;
                pShort = pShort.next;
            }
            return pLong;
    }

    int getListLength(ListNode pHead){
        int length = 0;
        ListNode p = pHead;
        while (p!=null) {
            ++length;
            p=p.next;
        }
        return length;
    }
}