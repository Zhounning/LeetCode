package leetCode;

/**
 * IsPalindrome
 */
public class isPalindrome {

    // 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

    // 说明：本题中，我们将空字符串定义为有效的回文串。
    public boolean IsPalindrome(String s) {

        if (s == null || s.length() == 0)
            return true;

        int p1 = 0;
        int p2 = s.length() - 1;

        while (p1 <= p2) {
            while (p1 < s.length() && !Character.isLetterOrDigit(s.charAt(p1)))
                p1++;

            while (p2 >= 0 && !Character.isLetterOrDigit(s.charAt(p2)))
                p2--;
            if (p1 <= p2) {

                if (Character.toLowerCase(s.charAt(p1)) != Character.toLowerCase(s.charAt(p2)))
                    return false;
                p1++;
                p2--;
            }
        }

        return true;
    }

    // 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    public boolean IsPalindrome(int x) {
        String s = String.valueOf(x);
        int p1 = 0;
        int p2 = s.length() - 1;
        while (p1 <= p2) {
            if (s.charAt(p1) != s.charAt(p2)) {
                return false;
            }
            p1++;
            p2--;

        }
        return true;
    }

    // 请判断一个链表是否为回文链表。
    public boolean IsPalindrome(ListNode head) {
        // 使用快慢指针
        ListNode fast = head;
        ListNode slow = head;
        ListNode cur = head;
        ListNode lastNode = null;
        // 利用快慢指针将前半段进翻转
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            cur.next = lastNode;
            lastNode = cur;
            cur = slow;
        }

        if (fast != null) {
            slow = slow.next;
        }
        cur = lastNode;
        while (cur != null) {
            if (cur.val != slow.val) {
                return false;
            }
            cur = cur.next;
            slow = slow.next;
        }
        return true;

    }

    public static void main(String[] args) {
        String s = "0P";
        isPalindrome isPalindrome = new isPalindrome();
        int x = -121;
        System.out.println(isPalindrome.IsPalindrome(x));
    }
}