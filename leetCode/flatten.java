package leetCode;

public class flatten {
    //在还没操作节点右子树前，不能破坏该节点的右子树指向。
    //所以使用last，而不是使用pre,并且使用后续遍历
    TreeNode last;
    public void Flatten(TreeNode root) {
        if (root==null) {
            return;
        }
        Flatten(root.right);
        Flatten(root.left);
        root.right = last;
        root.left = null;
        last =root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode a = new TreeNode(4);    
        TreeNode b = new TreeNode(8);    
        TreeNode c = new TreeNode(11);    
        TreeNode d = new TreeNode(13);    
        TreeNode e = new TreeNode(7);    
        TreeNode f = new TreeNode(2);    
        TreeNode g = new TreeNode(5);    
        TreeNode h = new TreeNode(1);
        root.left =a;root.right=b; 
    }
}