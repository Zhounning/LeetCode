package leetCode;

public class countNodes {

    public int CountNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return CountNodes(root.left) + CountNodes(root.right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root =new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        countNodes c = new countNodes();
        System.out.println(c.CountNodes(root));
    }
}