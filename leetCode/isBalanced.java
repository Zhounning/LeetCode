package leetCode;

public class isBalanced {
    public boolean IsBalanced(TreeNode root) {
        return IsBalance(root)!=-1;
    }

    private int IsBalance(TreeNode root){
        if(root==null)return 0;
        int left = IsBalance(root.left);
        // -1代表不平衡
        if (left==-1) {
            return -1;
        }
        int right = IsBalance(root.right);
        if (right==-1) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}