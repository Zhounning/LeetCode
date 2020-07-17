package leetCode;

public class minDepth {
    public int MinDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }
        //说明是叶子节点
        if (root.left==null && root.right==null) {
            return 1;
        }

        int left = root.left==null? Integer.MAX_VALUE : MinDepth(root.left);
        int right = root.right==null? Integer.MAX_VALUE : MinDepth(root.right);

        return Math.min(left, right)+1;
    }

   
    public static void main(String[] args) {
        
    }
}