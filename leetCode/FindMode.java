package leetCode;
import java.util.ArrayList;
import java.util.List;

/**
 * FindMode
 */
public class FindMode {
    // 例如：
    // 给定 BST [1,null,2,2],
    
    //    1
    //     \
    //      2
    //     /
    //    2
    // 返回[2].


    List<Integer> resList =new ArrayList<>();
    int count = 0;
    int maxcount = 0;
    TreeNode lastNode = null;
    public int[] findMode(TreeNode root) {
        helper(root);
        int[] res = new int[resList.size()];
        for (int i=0; i<res.length; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public void helper(TreeNode root){
        if (root==null) {
            return ;
        }
        //采用中序遍历,这样其实是类似于遍历一个数组
        helper(root.left);

        if (lastNode!=null&&root.val == lastNode.val) {
            count++;
        }else{
            count = 1;
        }

        if (count>maxcount) {
            resList.clear();
            resList.add(root.val);
            maxcount =count;
        }else if(count==maxcount){
            resList.add(root.val);
        }

        lastNode = root;
        helper(root.right);
    }
}