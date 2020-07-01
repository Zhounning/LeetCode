package leetCode;
/**
 * MaxArea
 */
public class MaxArea {

    // 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

    // 说明：你不能倾斜容器，且 n 的值至少为 2。
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/container-with-most-water
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public int maxArea(int[] height) {
        //暴力法，显然不是什么比较好的方法
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int area = (j-i)*Math.min(height[i],height[j]);
                res = Math.max(area, res);
            }
        }
        return res;
    }

    public int maxArea2(int[] height) {
        //看标签，是双指针，所以应该是双指针进行对应的解决,如何使用这双指针成为了一个问题
        //类似一个脑经急转弯
        int res = 0;

        int p1 = 0;
        int p2 = height.length-1;

        while (p1<p2) {
            int area = (p2-p1)*Math.min(height[p1],height[p2]);
            res = Math.max(area, res);
            
            if (height[p1]<height[p2]) {
                p1++;

            } else {
                p2--;
            }
        }
        return res;

    }
}