package leetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import javafx.util.Pair;

public class findLeastNumOfUniqueInts {
    public int FindLeastNumOfUniqueInts(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {

            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getKey()-o2.getKey();
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.add(new Pair<Integer, Integer>(entry.getValue(), entry.getKey()));
        }

        while (k > 0) {
            Pair<Integer, Integer> p = heap.poll();
            if (k >=p.getKey()) {
                // 说明可以移除这么多的数字
                k = k - p.getKey();
            } else {
                k = 0;
                heap.add(new Pair<Integer, Integer>(p.getKey() - k, p.getValue()));
            }
        }
        return heap.size();
    }

    public static void main(String[] args) {
        findLeastNumOfUniqueInts f = new findLeastNumOfUniqueInts();
        int[] arr = {4,3,1,1,3,3,2};
        int k = 3;
        System.out.println(f.FindLeastNumOfUniqueInts(arr, k));
    }
}