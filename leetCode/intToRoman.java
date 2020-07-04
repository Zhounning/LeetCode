package leetCode;

public class intToRoman {

    //贪婪算法的思想
    public String IntToRoman(int num) {
        if (num<1||num>3999) {
            return "";
        }
           // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        // 并且按照阿拉伯数字的大小降序排列，这是贪心选择思想
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < romans.length; i++) {
            while(num>=nums[i]){
                num -= nums[i];
                res.append(romans[i]);
            }
        }
        return res.toString();
    }
}