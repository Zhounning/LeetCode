import java.util.HashMap;

/**
 * PathSum
 */
public class PathSum {

    // 给定一个二叉树，它的每个结点都存放着一个整数值。

    // 找出路径和等于给定数值的路径总数。
    
    // 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
    
    // 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

//       10
//      /  \
//     5   -3
//    / \    \
//   3   2   11
//  / \   \
// 3  -2   1

// 返回 3。和等于 8 的路径有:

// 1.  5 -> 3
// 2.  5 -> 2 -> 1
// 3.  -3 -> 11

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/path-sum-iii
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/path-sum-iii
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int pathSum(TreeNode root, int sum) {
        
        if(root==null) return 0;

        int p = hepler(root, sum);  //以本身为父节点
        int r = pathSum(root.right, sum);   //以右孩子为父节点计算
        int l = pathSum(root.left, sum);    //以左节点为父节点计算
        return p+r+l;
    }

    
    /***
     * 返回当前路径上等于sum的路径数量
     * @param root
     * @param sum
     * @return
     */
    public int hepler(TreeNode root,int sum){

        if (root == null) {
            return 0;
        }

        int r = hepler(root.right, sum-root.val);
        int l = hepler(root.left, sum-root.val);
        return r+l+(root.val == sum ? 1 : 0);
    }


    public int pathSum2(TreeNode root, int k) {

        HashMap<Integer,Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        int sum = 0;
        return hepler2(root, sum, sumMap, k);
    }

     /***
      * 使用HashMap构造
      * @param root 根节点
      * @param sum  目前的总和
      * @param sumMap   
      * @param k    目标值
      * @return 返回总数
      */
    public int hepler2(TreeNode root,int sum,HashMap<Integer,Integer> sumMap,int k){
        if(root==null)
            return 0;

        sum +=root.val;
        int count = 0;
        if (sumMap.containsKey(sum-k)) {
            count+=sumMap.get(sum-k);
        }

        // if (sumMap.containsKey(sum)) {
        //     sumMap.put(sum, sumMap.get(sum)+1);
        // }else{
        //     sumMap.put(sum, 1);
        // }

        sumMap.put(sum, sumMap.getOrDefault(sum, 0)+1);

        count = count+hepler2(root.left, sum, sumMap, k)+hepler2(root.right, sum, sumMap, k);
        sumMap.put(sum, sumMap.get(sum)-1);
        
        return count;

    }
}