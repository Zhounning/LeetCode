package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class combinationSum3 {
    List<List<Integer>> res = new ArrayList<>();
    int k;

    public List<List<Integer>> CombinationSum3(int k, int n) {
        LinkedList<Integer> ans = new LinkedList<>();
        this.k = k;

        dfs(ans, 1, n);
        return res;
    }

    private void dfs(LinkedList<Integer> ans, int num, int target) {
        if (ans.size() == k) {
            // 说明有k个数
            if (target == 0) {
                res.add(new LinkedList<>(ans));
            }

            return;
        }

        for (int i = num; i <= 9; i++) {
            if (target - i < 0) {
                break;
            }
            ans.add(i);
            dfs(ans, i + 1, target - i);
            ans.removeLast();
        }
    }

    public static void main(String[] args) {
        combinationSum3 c = new combinationSum3();
        int k = 3;
        int n = 9;
        System.out.println(c.CombinationSum3(k, n));
    }
}