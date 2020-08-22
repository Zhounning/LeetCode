package leetCode;

import java.util.ArrayList;
import java.util.List;

public class findSmallestSetOfVertices {
    public List<Integer> FindSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();
        int[] inDegree = new int[n];

        for (List<Integer> cp : edges) {
            inDegree[cp.get(1)]++;
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        findSmallestSetOfVertices f = new findSmallestSetOfVertices();
        List<List<Integer>> edges = new ArrayList<>();
        
    }
}