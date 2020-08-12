package leetCode;

public class minInteger {
    char[] arr;

    // 思想越小，越往前换越好
    public String MinInteger(String num, int k) {

        arr = num.toCharArray();
        exchange(0, k);
        return new String(arr);
    }

    // 先使用递归
    void exchange(int start, int k) {
        if (k == 0) {
            return;
        }

        if (start == arr.length - 1) {
            return;
        }
        // 交换使用的次数
        int index = start;
        char ch = '9';
        for (int i = start; i < arr.length; i++) {
            // 说明后面交换不到了
            if (i - start > k) {
                break;
            }

            if (ch > arr[i]) {
                ch = arr[i];
                index = i;
            }
        }

        // 将位置进行移动
        for (int i = index; i >= start + 1; i--) {
            arr[i] = arr[i - 1];
        }
        arr[start] = ch;
        exchange(start + 1, k - (index - start));
    }

    public static void main(String[] args) {
        minInteger m = new minInteger();
        String num = "9438957234785635408";
        int k = 23;
        System.out.println(m.MinInteger(num, k));
    }

}