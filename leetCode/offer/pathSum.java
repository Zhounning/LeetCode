package leetCode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import leetCode.TreeNode;

public class pathSum {
    List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        f(root, sum, path);
        return ans;
    }

    void f(TreeNode root, int target, LinkedList<Integer> path) {
        if (root == null) {
            return;
        }

        if (target == root.val && root.left==null && root.right==null) {
            path.add(root.val);
            ans.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        path.add(root.val);
        f(root.left, target - root.val, path);
        f(root.right, target - root.val, path);
        path.removeLast();

    }

    public static void main(String[] args) {
        // pathSum p = new pathSum();
        // TreeNode root = new TreeNode(5);

    }

}