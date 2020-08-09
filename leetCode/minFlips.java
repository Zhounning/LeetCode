package leetCode;

public class minFlips {
    public int MinFlips(String target) {
        int count = 1;
        int i = 0;
        while (i < target.length() && target.charAt(i) == '0') {
            i++;
        }
        if (i == target.length()) {
            // 说明都是0
            return 0;
        }
        char ch = '1';
        for (; i < target.length(); i++) {
            if (ch != target.charAt(i)) {
                count++;
                ch = target.charAt(i);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        minFlips m = new minFlips();
        String target = "001011101";
        System.out.println(m.MinFlips(target));
    }
}