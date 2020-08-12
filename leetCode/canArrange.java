package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class canArrange {
    public boolean CanArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {  
            arr[i] = arr[i] % k;
            if (arr[i] < 0) {
                arr[i] += k;
            }


            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        if (map.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int t = entry.getKey(), occ = entry.getValue();
            if (t > 0 && map.getOrDefault(k - t, 0) != occ) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        canArrange c = new canArrange();
        int[] arr = { -1, 1, -2, 2, -3, 3, -4, 4 };
        int k = 3;
        System.out.println(c.CanArrange(arr, k));
    }
}