package leetCode;

public class isSymmetric {
    public boolean IsSymmetric(TreeNode root) {
        if (root==null) {
            return true;
        }
        return IsSymmetric(root.left,root.right);
    }

    boolean IsSymmetric(TreeNode pRoot1,TreeNode pRoot2){
        if (pRoot1==null&&pRoot2==null) {
            return true;
        }

        if (pRoot1==null||pRoot2==null) {
            return false;
        }

        return pRoot1.val==pRoot2.val && IsSymmetric(pRoot1.left,pRoot2.right) && IsSymmetric(pRoot1.right,pRoot2.left) ;
    }
}