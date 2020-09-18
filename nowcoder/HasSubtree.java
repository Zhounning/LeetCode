package nowcoder;

public class HasSubtree {
    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        boolean res = false;

        if (root1!=null&&root2!=null) {
            if (root1.val == root2.val) {
                res = isTreeEqual(root1, root2);
            }

            if (!res) {
                res =hasSubtree(root1.left, root2);
            }

            if (!res) {
                res =hasSubtree(root1.right, root2);
            }
        }

        return res;
    }


    public boolean isTreeEqual(TreeNode root1,TreeNode root2){
        if(root2==null){
            return true;
        }

        if (root1==null) {
            return false;
        }

        if(root1.val!=root2.val){
            return false;
        }

        return isTreeEqual(root1.left,root2.left) && isTreeEqual(root1.right, root2.right);
    } 
}