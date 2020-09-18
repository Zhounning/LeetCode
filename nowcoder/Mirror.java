package nowcoder;

public class Mirror {
    public void mirror(TreeNode root) {
        if(root==null) return;

        mirror(root.left);
        mirror(root.right);
        TreeNode temp =root.right;
        root.right = root.left;
        root.left = temp; 
    }
}