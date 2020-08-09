package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * countPairs
 */
public class countPairs {
    int distance = 0;
    int res = 0;

    public int CountPairs(TreeNode root, int distance) {
        this.distance = distance;
        dfs(root);
        return res;
    }

    List<Integer> dfs(TreeNode root) {
        ArrayList<Integer> dist = new ArrayList<>();
        if (root == null) {
            return dist;
        }

        // 说明是叶子节点
        if (root.left == null && root.right == null) {
            dist.add(1);
            return dist;
        }
        List<Integer> leftdist = dfs(root.left);
        List<Integer> rightdist = dfs(root.right);

        for (Integer integer : leftdist) {
            if (++integer >= distance)
                continue;
            dist.add(integer);
        }
        for (Integer integer : rightdist) {
            if (++integer >= distance)
                continue;
            dist.add(integer);
        }

        for (Integer integer : rightdist) {
            for (Integer integer2 : leftdist) {
                if (integer + integer2 <= distance) {
                    res++;
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        countPairs co = new countPairs();
        TreeNode root = new TreeNode(78);
        TreeNode a = new TreeNode(15);
        TreeNode b = new TreeNode(81);
        TreeNode c = new TreeNode(73);
        TreeNode d = new TreeNode(98);
        TreeNode e = new TreeNode(36);
        TreeNode f = new TreeNode(30);
        TreeNode g = new TreeNode(63);
        TreeNode h = new TreeNode(32);
        root.left = a;
        root.right = b;

        a.left = c;
        a.right = d;
        b.left = e;
        c.left = f;
        d.left = g;
        d.right = h;
        int distance = 6;
        System.out.println(co.CountPairs(root, distance));

    }
}