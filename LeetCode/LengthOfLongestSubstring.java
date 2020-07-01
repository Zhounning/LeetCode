package leetCode;
import java.util.HashMap;

/**
 * LengthOfLongestSubstring
 */
public class LengthOfLongestSubstring {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     */

    /***
     * 
     * @param s 传经来的字符串
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0)
            return 0;

        if(s.length()<2)
            return 1;

        int maxLength = 0;
       // int currentLength = 0;
        //采用双指针的办法，假设指针1和指针2之间是没有重复的值的
        int index1 = 0; //指针1
        int index2 = 1;//指针2

        while(true){

            //说明两者不相等
            for(int i=index1;i<index2;i++)
            {
                if(s.charAt(i)==s.charAt(index2)){
                    index1 = i+1; 
                }
            }
            // currentLength = index2 - index1;
            // if(currentLength>maxLength)
            //     maxLength = currentLength;
            maxLength = index2 -index1+1>maxLength?index2 -index1+1:maxLength;
            index2++;
            if(index2>=s.length())
                break;

        }
        return maxLength;
    }

    //采用滑动窗口
    public int lengthOfLongestSubstring2(String s){
        if(s==null||s.length()==0)
            return 0;
        //记录下个不相同字串的位置
        HashMap<Character,Integer> locationMap = new HashMap<>();
        int res = 0;

        for(int i=0;i<s.length();i++){
            Character a = s.charAt(i);
            if(locationMap.containsKey(a)){
                int last = locationMap.get(a);//得到上一次自己的位置
                //如果上次的位置和自己只隔一个
                if(last==i-1){
                    locationMap.clear();
                    locationMap.put(a, i);
                }else{

                }
            }else{
                locationMap.put(a, i);
                res = res<locationMap.size()?locationMap.size():res;
            }
        }
        return res;

    } 


    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        String s = "abcabcbb";
        System.out.println(l.lengthOfLongestSubstring2(s));
    }
}