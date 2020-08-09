package leetCode;

public class longestAwesome {
    public int LongestAwesome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] count = new int[128];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count[ch] += 1;
        }
        int odd = 0;
        int even = 0;
        int len = 0;
        for (int i : count) {
            if (i > 0) {
                if (i % 2 == 0) {
                    len += i;
                } else {
                    
                    if (i > 1) {
                        len += i - 1;
                    } else {
                        odd++;
                    }
                }
            }
        }
        if (odd > 0) {
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        longestAwesome l = new longestAwesome();
        String s = "234121442";
        System.out.println(l.LongestAwesome(s));
    }
}