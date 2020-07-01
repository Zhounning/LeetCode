package leetCode;
import java.util.HashSet;

/**
 * TotalFruit
 */
public class TotalFruit {
//     在一排树中，第 i 棵树产生 tree[i] 型的水果。
// 你可以从你选择的任何树开始，然后重复执行以下步骤：

// 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
// 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
// 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。

// 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。
// 用这个程序你能收集的水果总量是多少？

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/fruit-into-baskets
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public int totalFruit(int[] tree) {
        if(tree==null)
            return 0;
        
        if(tree.length<3)
            return tree.length;
        
        int res = 2;
        //表示当前的长度
        int length = 0;
        int lastLocation = -1;//记录下窗口开始滑动的位置
        //滑动窗口
       HashSet<Integer>windowsSet = new HashSet<>(); 
       //通过滑动窗口遍历
       for(int i=0;i<tree.length;i++){

           //如果set里面包含tree[i],则说明可以直接放在篮子里面
           if(windowsSet.size()==0){
            lastLocation = i;
            }

            if( windowsSet.contains(tree[i])){
                length++;
                if(length>res)
                    res = length;
            }else{
                //如果篮子里面没有这种水果
                //先判断set是否大于2，如果小于2说明没装满

                if (windowsSet.size()<2) {
                    windowsSet.add(tree[i]);
                    length++;
                    if(length>res)
                    res = length;
                   
                }else{
                    //说明已经装了两种水果，不能再装了，那么需要重新开始滑动窗口
                    i=lastLocation;
                    windowsSet.clear();
                    length = 0;
                }

            }
       }

       return res;
    }

    public static void main(String[] args) {
        TotalFruit t = new TotalFruit();
        int [] tree ={0,1,2};
        System.out.println(t.totalFruit(tree));
    }
}