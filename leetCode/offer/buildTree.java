package leetCode.offer;

import leetCode.TreeNode;

/**
 * buildTree
 */
public class buildTree {

    public TreeNode BuildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }

        return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    TreeNode dfs(int[] preorder, int[] inorder, int pstart, int pend, int istart, int iend) {
        if (pstart > pend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pstart]);
        if (pstart == pend) {
            return root;
        }
        int i = istart;
        for (; i < inorder.length; i++) {
            if (inorder[i] == preorder[pstart]) {
                break;
            }
        }
        TreeNode left = dfs(preorder, inorder, pstart + 1, pstart + i - istart, istart, i - 1);
        TreeNode right = dfs(preorder, inorder, pstart + i - istart + 1, pend, i + 1, iend);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = { 1, 2 };
        int[] inorder = { 2, 1 };
        buildTree b = new buildTree();
        System.out.println(b.BuildTree(preorder, inorder));

    }
}