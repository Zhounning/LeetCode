package leetCode;

/**
 * threeConsecutiveOdds
 */
public class threeConsecutiveOdds {

    public boolean ThreeConsecutiveOdds(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                count = 0;
            } else {
                count += 1;
            }
            if (count == 3) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        threeConsecutiveOdds t = new threeConsecutiveOdds();
        int []arr={1,2,34,3,4,5,7,23,12};
        System.out.println(t.ThreeConsecutiveOdds(arr));
    }
}