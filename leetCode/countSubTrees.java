package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class countSubTrees {

    /**
     * Node
     */
    public class Node {
        char label;
        List<Node> link;
        int i;

        public Node(char _label, List<Node> _link, int _i) {
            label = _label;
            link = _link;
            i = _i;
        }

    }

    int[] res;
    boolean[] isVisit;

    public int[] CountSubTrees(int n, int[][] edges, String labels) {
        res = new int[n];
        isVisit = new boolean[n];
        // List<Node> grap = new ArrayList<>();
        Node[] nodes = new Node[n];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(labels.charAt(i), new ArrayList<>(), i);
        }
        // 进行树的构建
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            nodes[a].link.add(nodes[b]);
            nodes[b].link.add(nodes[a]);
        }
        dfs(nodes[0]);
        return res;
    }

    // 深度优先遍历
    int[] dfs(Node node) {

        int[] map = new int[26];
        map[node.label - 'a']++;
        isVisit[node.i] = true;
        res[node.i] = 1;
        for (int i = 0; i < node.link.size(); i++) {
            if (!isVisit[node.link.get(i).i]) {
                int[] nums = dfs(node.link.get(i));
                for (int j = 0; j < 26; j++) {
                    map[j] += nums[j];
                }
                res[node.i] += nums[node.label - 'a'];
            }
        }

        return map;
    }

    public static void main(String[] args) {
        countSubTrees c = new countSubTrees();
        int n = 7;
        int[][] edges = new int[][] { new int[] { 0, 1 }, new int[] { 0, 2 }, new int[] { 1, 4 }, new int[] { 1, 5 },
                new int[] { 2, 3 }, new int[] { 2, 6 } };
        String labels = "abaedcd";
        System.out.println(Arrays.toString(c.CountSubTrees(n, edges, labels)));
    }
}