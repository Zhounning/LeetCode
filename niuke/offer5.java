package niuke;

import java.util.ArrayList;
import java.util.Stack;

public class offer5 {
    public static String replaceSpace(StringBuffer str) {
        if (str == null)
            return null;
        int fianl_length = str.length();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                fianl_length += 2;
            }
        }
        char[] res = new char[fianl_length];
        int p1 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                res[p1] = '%';
                res[p1 + 1] = '2';
                res[p1 + 2] = '0';
                p1 += 3;
            } else {
                res[p1] = str.charAt(i);
                ++p1;
            }
        }
        return String.valueOf(res);
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<Integer> st = new Stack<Integer>();
        while (listNode != null) {
            st.push(listNode.val);
            listNode = listNode.next;
        }

        while (!st.empty()) {
            res.add((Integer) st.pop());
        }
        return res;

    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
        str.append("hello world");
        offer5.replaceSpace(str);
    }
}