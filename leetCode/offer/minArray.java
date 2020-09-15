package leetCode.offer;

public class minArray {
    public int MinArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        // int mid = (left+right)/2;
        int mid = left + (right - left) / 2;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (numbers[mid] < numbers[right]) {
                //比后半段向左逼近
                // 说明右半段有序，进行舍弃
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                // 说明从 left 到 mid为有序
                left = mid + 1;
            } else {
                // 因为是寻找最小值所以，需要向左移
                right--;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        minArray m = new minArray();
        // int[] numbers = { 3, 4, 5, 1, 2 };
        // int[] numbers = { 2, 2, 2, 0, 1 };
        int[] numbers = { 1, 3, 5 };
        System.out.println(m.MinArray(numbers));

    }
}