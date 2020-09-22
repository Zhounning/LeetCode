package leetCode.offer;

import leetCode.TreeNode;

public class mirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);

        root.right = left;
        root.left = right;
        return root;
    }
}