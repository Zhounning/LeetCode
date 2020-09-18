package nowcoder;

import java.util.Stack;

public class Convert {
    public TreeNode convert(TreeNode pRootOfTree) {
        TreeNode root = null;
        TreeNode p = pRootOfTree;
        // 用于保存中序遍历序列的上一节点
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // boolean isFirst = true;
        while (p!=null||!stack.isEmpty()) {
            while (p!=null) {
                stack.push(p);
                p=p.left;
            }    

            if (!stack.isEmpty()) {
                p=stack.pop();
                if (root==null) {
                    // 将中序遍历序列中的第一个节点记为root
                    root = p;
                    pre = p;
                }else{
                    pre.right = p;
                    p.left = pre;
                    pre = p;
                }      
                p=p.right;
            }
        }
        return root;
       
    }

   
}