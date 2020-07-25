package leetCode;

public class canCompleteCircuit {
    public int CanCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0) {
            return -1;
        }

        if (cost == null || cost.length == 0) {
            return -1;
        }

        int i = 0;
        int len = gas.length;
        int start = -1;

        int sum = 0;
        int startSum = 0;
        while (i < len) {
            sum += gas[i] - cost[i];

            if (gas[i] - cost[i] > 0 && start == -1) {
                // 说明还未选择地方开始
                start = i;
                startSum = gas[i] - cost[i];
            } else if (start != -1) {
                // 说明已经选择地方开始
                startSum += gas[i] - cost[i];
                if (startSum < 0) {
                    start = -1;
                    startSum = 0;
                }
            }
            i++;
        }

        return sum >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        canCompleteCircuit c = new canCompleteCircuit();
        // int[] gas = { 4, 5, 2, 6, 5, 3 };
        int[] gas = { 1, 2, 3, 4, 5 };
        // int[] cost = { 3, 2, 7, 3, 2, 9 };
        int[] cost = { 3, 4, 5, 1, 2 };
        System.out.println(c.CanCompleteCircuit(gas, cost));
    }
}