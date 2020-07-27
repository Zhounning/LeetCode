package leetCode;

public class compareVersion {
    public int CompareVersion(String version1, String version2) {
        int i = 0;
        int j = 0;
        while (i < version1.length() || j < version2.length()) {
            int x = i, y = j;
            while (x < version1.length() && version1.charAt(x) != '.')
                x++;
            while (y < version2.length() && version2.charAt(y) != '.')
                y++;
            // 当 i> version1.length()时，直接补0
            int a = x == i ? 0 : Integer.parseInt(version1.substring(i, x));
            int b = y == j ? 0 : Integer.parseInt(version2.substring(j, y));
            if (a < b)
                return -1;
            if (a > b)
                return 1;
            i = x + 1;
            j = y + 1;
        }
        return 0;
    }
}