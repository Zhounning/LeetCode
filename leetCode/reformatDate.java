package leetCode;

import java.util.HashMap;
import java.util.Map;

public class reformatDate {

    public String ReformatDate(String date) {
        String year, month, day;
        String[] d = date.split(" ");
        Map<String, String> map = new HashMap<>();

        map.put("Jan", "01");
        map.put("Feb", "02");
        map.put("Mar", "03");
        map.put("Apr", "04");
        map.put("May", "05");
        map.put("Jun", "06");
        map.put("Jul", "07");
        map.put("Aug", "08");
        map.put("Sep", "09");
        map.put("Oct", "10");
        map.put("Nov", "11");
        map.put("Dec", "12");
        // 第一个是天
        int i = 0;
        while (d[0].charAt(i) >= '0' && d[0].charAt(i) <= '9') {
            i++;
        }
        day = d[0].substring(0, i);
        month = map.get(d[1]);
        year = d[2];
        if (day.length() == 1) {
            day = "0" + day;
        }
        return year + "-" + month + "-" + day;
    }

    public static void main(String[] args) {
        reformatDate r = new reformatDate();
        String date = "20th Oct 2052";
        System.out.println(r.ReformatDate(date));
    }
}
