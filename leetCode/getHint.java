package leetCode;

import java.util.HashMap;
import java.util.HashSet;

public class getHint {
    public String GetHint(String secret, String guess) {
        HashMap<Character, Integer> map = new HashMap<>();
        int A = 0;// 公牛
        int B = 0;// 母牛
        for (int i = 0; i < secret.length(); i++) {
            Character ch = secret.charAt(i);
            if (ch == guess.charAt(i)) {
                // 说明是公牛;
                ++A;
            } else {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

        }

        for (int i = 0; i < guess.length(); i++) {
            Character ch = guess.charAt(i);

            if (ch == secret.charAt(i)) {
                continue;
            }
            if (map.containsKey(guess.charAt(i))) {
                map.put(ch, map.get(ch) - 1);
                B++;
                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
            }
        }

        return A + "A" + B + "B";
    }

    public static void main(String[] args) {
        getHint g = new getHint();
        String secret = "1807", guess = "7810";
        System.out.println(g.GetHint(secret, guess));
    }
}