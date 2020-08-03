package leetCode;

public class productExceptSelf {
    // 使用除法
    public int[] ProductExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int multiplyNum = 1;
        int zeroNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                multiplyNum *= nums[i];
            else
                zeroNum++;

        }

        if (zeroNum > 1) {
            return res;
        }

        for (int i = 0; i < res.length; i++) {
            if (zeroNum == 0) {
                // 0的数量为0
                res[i] = multiplyNum / nums[i];
            } else {
                // 0的数量为1
                if (nums[i] == 0) {
                    res[i] = multiplyNum;
                }
            }
        }
        return res;
    }

    // 不使用除法,
    // 参考：https://leetcode-cn.com/problems/product-of-array-except-self/solution/product-of-array-except-self-shang-san-jiao-xia-sa/
    public int[] ProductExceptSelf2(int[] nums) {
        int[] res = new int[nums.length];
        int p = 1, q = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = p;
            p *= nums[i];
        }
        for (int i = nums.length - 1; i > 0; i--) {
            q *= nums[i];
            res[i - 1] *= q;
        }
        return res;
    }
}