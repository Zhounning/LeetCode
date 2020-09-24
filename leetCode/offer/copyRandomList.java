package leetCode.offer;

import java.util.HashMap;

public class copyRandomList {

    public Node CopyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node p = head;
        Node pre = null;
        while (p != null) {
            Node node = null;
            if (!map.containsKey(p)) {
                node = new Node(p.val);
                map.put(p, node);
            } else {
                node = map.get(p);
            }

            Node random = null;
            if (p.random != null && !map.containsKey(p.random)) {
                random = new Node(p.random.val);
                map.put(p.random, random);
            } else {
                random = map.getOrDefault(p.random, null);
            }

            node.random = random;
            if (pre != null) {
                pre.next = node;
            }

            pre = node;
            p = p.next;
        }

        return map.get(head);
    }

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
