package leetCode;

public class countOdds {
    public int CountOdds(int low, int high) {
        if (low % 2 == 0) {
            low++;
        }

        if (high % 2 == 0) {
            high--;
        }
        int res = 0;
        if (low <= high) {
            res = (high - low) / 2 + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        countOdds c = new countOdds();
        int low = 0, high = 0;
        System.out.println(c.CountOdds(low, high));
    }
}