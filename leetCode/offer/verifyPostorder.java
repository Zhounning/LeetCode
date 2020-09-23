package leetCode.offer;

/**
 * verifyPostorder
 */
public class verifyPostorder {

    public boolean VerifyPostorder(int[] postorder) {
        return f(postorder, 0, postorder.length - 1);
    }

    public boolean f(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int p = left;
        // 右子树
        while (postorder[p] < postorder[right]) {
            p++;
        }
        int m = p;
        // 左子树
        while (postorder[p] > postorder[right]) {
            p++;
        }
        // p==right
        return p == right && f(postorder, left, m - 1) && f(postorder, m, right - 1);
    }
}