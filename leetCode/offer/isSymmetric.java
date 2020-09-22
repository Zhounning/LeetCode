package leetCode.offer;

import leetCode.TreeNode;

public class isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    boolean isSymmetric(TreeNode A,TreeNode B) {
        if (A == null && B == null) {
            return true;
        }

        if (A == null || B == null) {
            return false;
        }

        if (A.val != B.val) {
            return false;
        }
        return isSymmetric(A.left,B.right) && isSymmetric(A.right,B.left);
    }
}