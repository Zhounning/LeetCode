package leetCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

/**
 * PathSum
 * 202-07-22重做
 */
public class pathSum {
    
    List<List<Integer>> res;
    public List<List<Integer>> PathSum(TreeNode root, int sum) {
        res = new LinkedList<>();
        LinkedList<Integer>path = new LinkedList<>();
        dfs(root, sum, path);
        return res;
    }

    void dfs(TreeNode root, int sum,LinkedList<Integer>path){
        if (root==null) {
            return;
        }
        path.add(root.val);
        //说明是跟节点且确实到达
        if (sum-root.val==0 && root.left==null && root.right==null) {
            res.add(new LinkedList(path));
            path.removeLast();
            return ;
        }

        dfs(root.left,sum-root.val,path);
        dfs(root.right,sum-root.val,path);
        path.removeLast();
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