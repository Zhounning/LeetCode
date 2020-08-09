package leetCode;

import java.util.ArrayList;
import java.util.List;

public class numOfSubarrays {

    // 暴力法不可取
    public int NumOfSubarrays(int[] arr) {
        int odd = 0;
        int pre = -1;
        // 统计奇数前的偶数
        int even = 0;
        long res = 0;
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (i % 2 != 0) {
                // 说明是奇数
                res += (pre + 1) * (even + 1);
                pre = even;
                list.add(even);
                even = 0;
                odd++;
            } else {
                even++;
            }
        }
        res += (pre + 1) * (even + 1);
        list.add(even);

        if (odd % 2 == 0) {
            // 说明奇数的个数为偶数
            odd--;
        }
        // 外围对奇数个数进行遍历
        for (int i = 3; i <= odd; i += 2) {
            for (int j = 0; j + i < list.size(); j++) {
                int a = list.get(j);
                int b = list.get(j + i);
                res += (a + 1) * (b + 1);
            }
        }
        return (int) (res % 1000000007);
    }

    // 使用前缀和
    public int NumOfSubarrays2(int[] arr) {
        int odd = 0;
        int even = 1;
        int sum = 0;
        long res = 0;
        for (int i : arr) {
            sum += i;
            res += sum % 2 == 0 ? odd : even;
            if (sum%2==0) {
                even++;
            }else{
                odd++;
            }
        }
        return(int) (res % 1000000007);
    }

    public static void main(String[] args) {
        numOfSubarrays n = new numOfSubarrays();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println(n.NumOfSubarrays2(arr));
    }
}