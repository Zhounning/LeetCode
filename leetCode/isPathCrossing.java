package leetCode;

import java.util.HashSet;
import java.util.Set;

import javafx.scene.effect.Light.Point;
import javafx.util.Pair;

public class isPathCrossing {
    /**
     * point
     */
    public class Point {
        int x;
        int y;

        @Override
        public boolean equals(Object obj) {
            // TODO Auto-generated method stub
            if (obj instanceof Point) {
                Point p = (Point) obj;
                return (p.x == x) && (p.y == y);
            }
            return false;
        }

        @Override
        public int hashCode() {
            // TODO Auto-generated method stub
            return (x<<1)|y;
        }
        public Point(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }

    public boolean isPathCrossing(String path) {
        Set<Point> set = new HashSet<>();
        int x = 0, y = 0;
        set.add(new Point(0, 0));
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'N') {
                y++;
            } else if (path.charAt(i) == 'S') {
                y--;
            } else if (path.charAt(i) == 'E') {
                x++;
            } else {
                x--;
            }
            Point o = new Point(x, y);
            if (set.contains(o)) {
                return true;
            }
            set.add(o);
        }
        return false;
    }

    public static void main(String[] args) {
        isPathCrossing i = new isPathCrossing();
        String path = "NESWW";
        System.out.println(i.isPathCrossing(path));
    }
}