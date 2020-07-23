package leetCode;


public class connect {
    public Node Connect(Node root) {
        if(root==null || (root.left==null && root.right==null))
            return root;

        root.left.next = root.right;
        //这一步很巧妙
        if(root.next != null){
            root.right.next = root.next.left;
        }
        //深度遍历
        Connect(root.left);
        Connect(root.right);
        return root;
    }
}