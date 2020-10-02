package leetCode.offer;

import leetCode.TreeNode;

public class lowestCommonAncestor {
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode t = root;
        while ((t.val < p.val && t.val < q.val) || (t.val > p.val && t.val > q.val)) {
            if (t.val < p.val && t.val < q.val) {
                t = t.right;
            } else {
                t = t.left;
            }
        }
        return t;
    }

    // 在两边寻找这个节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }
}