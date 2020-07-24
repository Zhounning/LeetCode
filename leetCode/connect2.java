package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class connect2 {
    //使用层次遍历，复杂度比较高
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        
        Queue<Node> Q = new LinkedList<Node>(); 
        Q.add(root);
        //利用层次遍历
        while (Q.size() > 0) {
            
            int size = Q.size();
            
            for(int i = 0; i < size; i++) {
                
                Node node = Q.poll();
                
                if (i < size - 1) {
                    node.next = Q.peek();
                }
                
                if (node.left != null) {
                    Q.add(node.left);
                }
                if (node.right != null) {
                    Q.add(node.right);
                }
            }
        }
        return root;
    }

    //通过递归，第N层利用第N-1层
    public Node Connect2(Node root) {
        if (root == null || (root.right == null && root.left == null)) {
            return root;
        }
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            root.right.next = getNextNoNullChild(root);
        }
        if (root.left == null) {
            root.right.next = getNextNoNullChild(root);
        }
        if (root.right == null) {
            root.left.next = getNextNoNullChild(root);
        }

        //这里要注意：先递归右子树，否则右子树根节点next关系没建立好，左子树到右子树子节点无法正确挂载
        root.right = Connect2(root.right);
        root.left = Connect2(root.left);

        return root;
    }

    /**
     * 一路向右找到有子节点的根节点
     */
    private  Node getNextNoNullChild(Node root) {
        while (root.next != null) {
            if (root.next.left != null) {
                return root.next.left;
            }
            if (root.next.right != null) {
                return root.next.right;
            }
            root = root.next;
        }
        return null;
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

