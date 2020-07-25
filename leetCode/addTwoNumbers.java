package leetCode;

/**
 * 2020-07-02 重新写
 */
public class addTwoNumbers {

    public ListNode AddTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode l3 = null;
        ListNode p3 = null;
        int a, c = 0;// a表示相加之后的值，c表示进位
        int addnum1 = 0, addnum2 = 0;
        while (p1 != null || p2 != null) {
            addnum1 = p1 == null ? 0 : p1.val;
            addnum2 = p2 == null ? 0 : p2.val;

            a = (addnum1 + addnum2 + c) % 10;
            c = (addnum1 + addnum2 + c) / 10;

            if (l3 == null) {
                l3 = new ListNode(a);
                p3 = l3;
            } else {
                p3.next = new ListNode(a);
                p3 = p3.next;
            }

            if (p1 != null)
                p1 = p1.next;
            if (p2 != null)
                p2 = p2.next;
        }

        // 最后的进位
        if (c > 0) {
            p3.next = new ListNode(c);
        }

        return l3;
    }

    public static void main(String[] args) {

    }
}