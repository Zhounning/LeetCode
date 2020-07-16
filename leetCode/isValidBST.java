package leetCode;

public class isValidBST {
    //这个pre非常巧妙
    Integer pre = Integer.MIN_VALUE;
    public boolean IsValidBST(TreeNode root) {
        if (root==null) {
            return true;
        }
   
        if(!IsValidBST(root.left)){
            return false;
        };

        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        
        return IsValidBST(root.right);
    }
}