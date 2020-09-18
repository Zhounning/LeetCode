package nowcoder;

public class GetNumberOfK {
    public int getNumberOfK(int[] array, int k) {
        int number = 0;
        if (array != null && array.length > 0) {
            int first = GetFirstK(array, k, 0, array.length - 1);
            int last = GetLastK(array, k, 0, array.length - 1);

            if (first > -1 && last > -1) {
                number = last - first + 1;
            }
        }
        return number;
    }

    int GetFirstK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        int midData = array[mid];

        if (midData == k) {
            if ((mid > 0 && array[mid - 1] != k) || mid == 0) {
                return mid;
            } else {
                end = mid - 1;
            }
        } else if (midData > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return GetFirstK(array, k, start, end);
    }

    int GetLastK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        int midData = array[mid];

        if (midData == k) {
            if ((mid < array.length - 1 && array[mid + 1] != k) || mid == array.length - 1) {
                return mid;
            } else {
                start = mid + 1;
            }
        } else if (midData < k) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
        return GetLastK(array, k, start, end);
    }

    public static void main(String[] args) {
        GetNumberOfK g = new GetNumberOfK();
        int[] array = { 1, 2, 3, 3, 3, 3, 4, 5 };
        System.out.println(g.getNumberOfK(array, 3));
    }
}