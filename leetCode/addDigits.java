package leetCode;

public class addDigits {
    // 利用循环
    public int AddDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    // 数学方法，时间O(1)
    public int AddDigits2(int num) {
        return (num-1)%9+1;
    }

    public static void main(String[] args) {
        addDigits a = new addDigits();
        int num = 10;
        System.out.println(a.AddDigits(num));
    }
}