package nowcoder;

import sun.misc.Unsafe;

public class GetNext {
    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        TreeLinkNode res = null;
        // 右边结点不为空
        if (pNode.right != null) {
            res = pNode.right;
            while (res.left != null) {
                res = res.left;
            }
            return res;
        }
        // 父节点不为空
        while (pNode.next != null) {
            res = pNode.next;
            if (res.left == pNode) {
                return res;
            }
            pNode = pNode.next;
        }
        return res;
    }
}