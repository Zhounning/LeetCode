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

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}

