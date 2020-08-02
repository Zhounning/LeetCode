package niuke;

public class NumberOf1Between1AndN_Solution {
    public int numberOf1Between1AndN_Solution(int n) {
        // 链接：https://www.nowcoder.com/questionTerminal/bd7f978302044eee894445e244c7eee6?f=discussion
        // 来源：牛客网

        if (n <= 0)
            return 0;
        int count = 0;
        for (long i = 1; i <= n; i *= 10) {
            long diviver = i * 10;
            count += (n / diviver) * i + Math.min(Math.max(n % diviver - i + 1, 0), i);
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Between1AndN_Solution nu = new NumberOf1Between1AndN_Solution();
        int n = 113;
        System.out.println(nu.numberOf1Between1AndN_Solution(n));
    }
}