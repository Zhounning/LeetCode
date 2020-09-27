package leetCode.offer;

import leetCode.TreeNode;

public class kthLargest {
    int res, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        k--;
        if (k == 0) {
            res = root.val;
        }
        dfs(root.left);
    }
}