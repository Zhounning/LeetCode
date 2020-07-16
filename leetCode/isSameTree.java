package leetCode;

public class isSameTree {
    public boolean IsSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null)  return true;
        if(p==null || q==null)return false;

        return p.val==q.val && IsSameTree(p.left,q.left) && IsSameTree(p.right,q.right);
    }
}