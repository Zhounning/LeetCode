package leetCode;

public class buildTree {
    int[] preorder;
    int[] inorder;

    public TreeNode BuildTree(int[] preorder, int[] inorder) {
        if (preorder==null || preorder.length==0) {
            return null;
        }
        this.preorder = preorder;
        this.inorder = inorder;
        return BuildTree(0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode BuildTree(int pStart,int pEnd, int inStart,int inEnd){
        
        //第一个是根节点
        TreeNode root = new TreeNode(preorder[pStart]);
        if (pStart==pEnd) {
            return root;   
        }
        int i=inStart;
        //从中序遍历中找出根节点，将其分开
        for (; i <=inEnd; i++) {
            if (preorder[pStart] == inorder[i]) {
                break;
            }
        }
        int len = i-inStart;
        if (pStart+1<=pStart+len) 
            root.left = BuildTree(pStart+1,pStart+len,inStart,i-1);
        if (pStart+len+1<=pEnd) 
            root.right = BuildTree(pStart+len+1,pEnd,i+1,inEnd);
        return root;
    }

    public static void main(String[] args) {
        buildTree b = new buildTree();
        int[] preorder = {1,2};
        int[] inorder = {2,1};
        b.BuildTree(preorder, inorder);
    }

}