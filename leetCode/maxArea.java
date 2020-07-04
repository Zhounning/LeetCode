package leetCode;
/**
 * MaxArea
 * 2020-07-04 重做
 */
public class maxArea {

    // 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

    // 说明：你不能倾斜容器，且 n 的值至少为 2。
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/container-with-most-water
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    //使用双指针重做
    public int MaxArea(int[] height) {
        if(height==null||height.length<=0)return 0;

        int p1 = 0;
        int p2 = height.length-1;
        int area = 0;

        while(p1<p2){
            if((p2-p1)*Math.min(height[p1],height[p2])>area)
                area = (p2-p1)*Math.min(height[p1],height[p2]);
            
            if (height[p1]<height[p2]) {
                p1++;
            } else {
                p2--;
            }
        }
        return area;

    }

}