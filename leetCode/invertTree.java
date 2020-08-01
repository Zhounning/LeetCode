package leetCode;

public class invertTree {
    public TreeNode InvertTree(TreeNode root) {
        if (root==null) {
            return null;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        InvertTree(root.left);
        InvertTree(root.right);
        return root;
    }
}