package leetCode;

public class buildTree2 {
    int[] postorder;
    int[] inorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (postorder == null || postorder.length == 0) {
            return null;
        }
        this.postorder = postorder;
        this.inorder = inorder;
        return BuildTree(0, postorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode BuildTree(int pStart, int pEnd, int inStart, int inEnd) {

        // 最后一个是根节点
        TreeNode root = new TreeNode(postorder[pEnd]);
        if (pStart == pEnd) {
            return root;
        }
        int i = inStart;
        // 从中序遍历中找出根节点，将其分开
        for (; i <= inEnd; i++) {
            if (postorder[pEnd] == inorder[i]) {
                break;
            }
        }
        int len = i - inStart;
        if (pStart <= pStart + len - 1)
            root.left = BuildTree(pStart, pStart + len - 1, inStart, i - 1);
        if (pStart + len <= pEnd - 1)
            root.right = BuildTree(pStart + len, pEnd - 1, i + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        buildTree2 b = new buildTree2();
        int[] postorder = { 9, 15, 7, 20, 3 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        b.buildTree(inorder, postorder);
    }
}