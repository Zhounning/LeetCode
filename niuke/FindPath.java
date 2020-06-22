package niuke;

import java.util.ArrayList;

public class FindPath {
    public ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
        if (root==null) {
            return res;
        }
        ArrayList<Integer> path = new ArrayList<>();
        dfs(root, target, path);
        return res;
    }

    public void dfs(TreeNode root,int target,ArrayList<Integer> path){
        target = target-root.val;
        path.add(root.val);
        //判断是否为叶子节点
        boolean isLeaf = root.left==null&&root.right==null;

        if (target==0&&isLeaf) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (Integer integer : path) {
                arrayList.add(integer);
            }
            res.add(arrayList);
        }

        if (root.left!=null) {
            dfs(root.left, target, path);
        }

        if (root.right!=null) {
            dfs(root.right, target, path);
        }

        path.remove(path.size()-1);
    }
}