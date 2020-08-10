package leetCode;

public class numWaterBottles {
    public int NumWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        int p = 0;
        while (numBottles >= numExchange) {
            p = numBottles;
            numBottles = numBottles / numExchange;
            res += numBottles;
            numBottles += p % numExchange;
        }
        return res;
    }

    public static void main(String[] args) {
        numWaterBottles n = new numWaterBottles();
        int numBottles = 15;
        int numExchange = 4;
        System.out.println(n.NumWaterBottles(numBottles, numExchange));
    }
}