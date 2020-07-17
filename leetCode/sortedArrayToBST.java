package leetCode;

public class sortedArrayToBST {
    int[] nums;
    public TreeNode SortedArrayToBST(int[] nums) {
        if (nums==null||nums.length==0) {
            return null;
        }
        this.nums=nums;
        return creatTree(0, nums.length-1);
    }

    TreeNode creatTree(int start,int end){
        if (start>end) {
            return null;
        }
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        if (start!=end) {
            root.left = creatTree(start,mid-1);
            root.right = creatTree(mid+1,end);
        }
        return root;
    }
}