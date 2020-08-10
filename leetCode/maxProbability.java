package leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import javafx.util.Pair;

public class maxProbability {
    /**
     * Node
     */
    class Node {
        int i;// 表示概率
        List<Node> link;// 表示邻居
        Map<Node, Double> edges;

        public Node(int _i, List<Node> _link, Map<Node, Double> _edges) {
            i = _i;
            link = _link;
            edges = _edges;
        }
    }

    public double MaxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // 初始化
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, new ArrayList<>(), new HashMap<Node, Double>());
        }
        // 添加边
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            nodes[a].link.add(nodes[b]);
            nodes[b].link.add(nodes[a]);
            nodes[a].edges.put(nodes[b], succProb[i]);
            nodes[b].edges.put(nodes[a], succProb[i]);
        }

        return ShortestPath2(start, end, n, nodes);
    }

    // 复杂的dijkstra算法时间超时
    double ShortestPath(Node start, Node end, int n, Node[] nodes) {
        double dist[] = new double[n];
        dist[start.i] = 1;

        // 初始化概率
        for (int i = 0; i < n; i++) {
            if (i != start.i) {
                dist[i] = start.edges.getOrDefault(nodes[i], 0.0d);
            }
        }
        boolean[] isVisit = new boolean[n];
        isVisit[start.i] = true;

        for (int i = 0; i < n - 1; i++) {
            double maxp = 0.0;
            int u = start.i;
            // 选取不在isVisit中具有最大概率的路径顶点u
            for (int j = 0; j < n; j++) {
                if (!isVisit[j] && dist[j] > maxp) {
                    u = j;
                    maxp = dist[j];
                }
            }

            isVisit[u] = true;
            for (int j = 0; j < n; j++) {
                double w = nodes[u].edges.getOrDefault(nodes[j], 0.0d);
                // 有路径且概率变大
                if (!isVisit[j] && w != 0.0 && dist[u] * w > dist[j]) {
                    dist[j] = dist[u] * w;
                }
            }

        }
        return dist[end.i];
    }

    

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 0, 2 } };
        double[] succProb = { 0.5, 0.5, 0.2 };
        int start = 0, end = 2;

        maxProbability m = new maxProbability();
        System.out.println(m.MaxProbability(n, edges, succProb, start, end));
    }

}