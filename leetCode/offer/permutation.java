package leetCode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class permutation {
    public String[] permutation(String s) {
        char[] arr = s.toCharArray();
        dfs(arr, 0);
        String[] a = new String[ans.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = ans.get(i);
        }
        return a;
    }

    ArrayList<String> ans = new ArrayList<>();

    void dfs(char[] arr, int start) {
        if (start == arr.length) {
            ans.add(new String(arr));
        }
        Set<Character> set = new HashSet<>();
        for (int i = start; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                continue;
            }
            set.add(arr[i]);
            swap(arr, i, start);
            dfs(arr, start + 1);
            swap(arr, i, start);
        }
    }

    void swap(char[] arr, int i, int j) {
        char ch = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;
    }
}