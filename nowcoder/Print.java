package nowcoder;

import java.util.ArrayList;
import java.util.Stack;

public class Print {
    public ArrayList<ArrayList<Integer> > print(TreeNode pRoot) {
        int c = 1;//表示第几层
        ArrayList<ArrayList<Integer> > res =new ArrayList<>();
        if (pRoot==null) {
            return res;
        }

        //队列形式
        // LinkedList<TreeNode> treeQueue = new LinkedList<>();
        Stack<TreeNode> treeStack0 = new Stack<>(); //表示偶数层
        Stack<TreeNode> treeStack1 = new Stack<>();//表示奇数层
        treeStack1.add(pRoot);
        
        while (!treeStack0.isEmpty() || !treeStack1.isEmpty() ) {
            TreeNode p =null;
            ArrayList<Integer> temp = new ArrayList<>();

            //判断是奇数层还是偶数层
            if (c%2==1) {
                while (!treeStack1.isEmpty()) {
                    p=treeStack1.pop();
                    temp.add(p.val);
                    if(p.left!=null)treeStack0.add(p.left);
                    if(p.right!=null)treeStack0.add(p.right);
                }

            }else{
                while (!treeStack0.isEmpty()) {
                    p=treeStack0.pop();
                    temp.add(p.val);
                    if(p.right!=null)treeStack1.add(p.right);
                    if(p.left!=null)treeStack1.add(p.left);
                }
            }

            c++;
            if (!temp.isEmpty()) {
                res.add(temp);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode pleft = new TreeNode(2);
        pleft.left = new TreeNode(4);
        pleft.right = new TreeNode(5);
        TreeNode pright = new TreeNode(3);
        // pright.left  = new TreeNode(6);
        pright.right  = new TreeNode(7);
        root.left = pleft;
        root.right = pright;
        Print p = new Print();
        ArrayList<ArrayList<Integer>>res =  p.print(root);
        System.out.println(res);
    }
}