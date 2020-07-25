package leetCode;

import java.util.HashMap;

public class copyRandomList {

    public Node CopyRandomList(Node head) {
        if (head==null) {
            return null;
        }

        HashMap<Node,Node> map = new HashMap<>();
        Node p = head;
        map.put(p, new Node(p.val));
        
        while (p!=null) {
            
            if (p.next!=null) {
                if (!map.containsKey(p.next)) {
                    map.put(p.next,new Node(p.next.val));
                }
                map.get(p).next = map.get(p.next);
            }

            if (p.random!=null) {
                
                if (!map.containsKey(p.random)) {
                    map.put(p.random,new Node(p.random.val));
                }
                map.get(p).random = map.get(p.random);
            }
            p=p.next;
        }
        return map.get(head);
    }

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