package nowcoder;

/**
 * isSymmetrical
 */
public class isSymmetrical {

    boolean IsSymmetrical(TreeNode pRoot)
    {
        return IsSymmetrical(pRoot, pRoot);
    }

    boolean IsSymmetrical(TreeNode pRoot1,TreeNode pRoot2){
        if (pRoot1==null && pRoot2==null) {
            return true;
        }

        if (pRoot1==null || pRoot2==null) {
            return false;
        }

        if (pRoot1.val!=pRoot2.val) {
            return false;
        }

        return IsSymmetrical(pRoot1.left, pRoot2.right) && IsSymmetrical(pRoot1.left, pRoot2.right);
    }
}