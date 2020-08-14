package niuke.bibili;

import java.util.Scanner;

/**
 * test1
 */
public class test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // String s = sc.nextLine();
        String s = "I am a student.";
        test1 t = new test1();
        char[] arr = s.toCharArray();
        t.reverseStr(arr);
        System.out.println(arr);
    }

    public void reverseStr(char[] arr) {
        int n = arr.length;
        reverse(arr, 0, n - 1);
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                reverse(arr, start, i - 1);
                start = i + 1;
            }
        }
        reverse(arr, start, n-1);
    }

    void reverse(char[] arr, int left, int right) {
        for (int i = left; i <= (left + right) / 2; i++) {
            swap(arr, i, right + left - i);
        }
    }

    void swap(char[] arr, int i, int j) {
        char ch = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;
    }
}