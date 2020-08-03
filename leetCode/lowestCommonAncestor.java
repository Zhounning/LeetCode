package leetCode;

public class lowestCommonAncestor {
    // 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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

    // 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    public TreeNode LowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = LowestCommonAncestor2(root.left, p, q);
        TreeNode right = LowestCommonAncestor2(root.right, p, q);
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }
}