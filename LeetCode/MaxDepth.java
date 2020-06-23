/**
 * MaxDepth
 */
public class MaxDepth {
    // 给定一个二叉树，找出其最大深度。

    // 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
    
    // 说明: 叶子节点是指没有子节点的节点。
    public int maxDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        return Math.max(maxDepth(left)+1, maxDepth(right)+1) ;
    }

    

}

/**
 * Definition for a binary tree node.
 * 
 **/
class TreeNode {
      int val;
      TreeNode left;
       TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
