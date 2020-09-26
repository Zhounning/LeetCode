package leetCode.offer;

public class findNthDigit {
    public int FindNthDigit(int n) {
        long digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;// 加一位
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((int) ((n - 1) % digit)) - '0';
    }
}