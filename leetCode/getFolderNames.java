package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class getFolderNames {
    public String[] GetFolderNames(String[] names) {
        int k = 1;
        HashMap<String, Integer> map = new HashMap<>();
        String[] res = new String[names.length];
        for (int i = 0; i < names.length; i++) {

            if (map.containsKey(names[i])) {
                k = map.get(names[i]);

                while (map.containsKey(names[i] + "(" + k + ")")) {
                    k++;
                }
                res[i] = names[i] + "(" + k + ")";
                map.put(names[i], k + 1);
            } else {
                res[i] = names[i];
            }
            map.put(res[i], 1);

        }
        return res;
    }

    public static void main(String[] args) {
        getFolderNames g = new getFolderNames();
        String[] names = {"wano","wano","wano","wano" };
        System.out.println(Arrays.toString(g.GetFolderNames(names)));
    }
}