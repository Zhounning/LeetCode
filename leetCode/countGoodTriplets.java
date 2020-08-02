package leetCode;

public class countGoodTriplets {

    public int CountGoodTriplets(int[] arr, int a, int b, int c) {
        if (arr == null || arr.length < 3) {
            return 0;
        }

        if (a < 0 || b < 0 || c < 0) {
            return 0;
        }
        int count = 0;

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 满足第一个条件
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < n; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                            ++count;
                        }
                    }
                }

            }
        }
        return count;
    }

    public static void main(String[] args) {
        countGoodTriplets co = new countGoodTriplets();
        int[] arr = { 1, 1, 2, 2, 3 };
        int a = 0;
        int b = 0;
        int c = 1;
        System.out.println(co.CountGoodTriplets(arr, a, b, c));
    }

}