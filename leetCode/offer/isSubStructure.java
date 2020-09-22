package leetCode.offer;

import leetCode.TreeNode;

public class isSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }

        if (A == null) {
            return false;
        }

        if (A.val == B.val && isSame(A, B)) {
            return true;
        } else {
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
    }

    boolean isSame(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }

        if (A == null) {
            return false;
        }

        if (A.val != B.val) {
            return false;
        }
        return isSame(A.left, B.left) && isSame(A.right, B.right);
    }
}