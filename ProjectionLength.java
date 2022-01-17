import java.util.*;

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static int checkIntersectionOfTwoLineSegments(Point a1, Point b1,
                                                      Point a2, Point b2) {
        int res = 0;
        if (b1.x < a1.x) {

            Point tmp = a1;
            a1 = b1;
            b1 = tmp;
        }

        if (b2.x < a2.x) {

            Point tmp = a2;
            a2 = b2;
            b2 = tmp;
        }


        //no intersect
        if (b1.x < a2.x || b2.x < a1.x) {
            res = 0;
        } else if (a1.x == b2.x) {
            res = 0;
        } else if (b1.x == a2.x) {
            res = 0;
        } else if(a1.x <= a2.x && a2.x< b1.x && b1.x< b2.x) {
            res = b1.x - a2.x;
        } else if (a2.x <= a1.x && a1.x < b2.x && b2.x < b1.x) {
            res = b2.x - a1.x;
        } else if(a1.x < a2.x && a2.x < b2.x && b2.x <= b1.x) {
            res = b2.x - a2.x;
        } else if (a2.x < a1.x && a1.x < b1.x && b1.x <= b2.x) {
            res = b1.x - a1.x;
        } else if (a1.x == a2.x && b1.x == b2.x) {
            res = b1.x - a1.x;
        }
        return res;
    }
}

public class ProjectionLength {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> coordinates = new ArrayList<>();

        while (scanner.hasNextInt()) {
            coordinates.add(scanner.nextInt());
        }

        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0; i < coordinates.size(); i+=2) {
            points.add(new Point(coordinates.get(i),coordinates.get(i +1)));
        }

        System.out.print(Point.checkIntersectionOfTwoLineSegments(points.get(0),points.get(1),points.get(2),points.get(3)));


    }
}
