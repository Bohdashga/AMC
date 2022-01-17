import java.util.*;

class PointCoordinate {
    public double y;
    public double x;


    public PointCoordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

}
public class IsPointInsideConvexPolygon {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> numbers = new ArrayList<>();

        while (scanner.hasNextDouble()) {
            numbers.add(scanner.nextDouble());
        }

        double first = numbers.get(0);
        double second = numbers.get(1);

        List<Double> part = numbers.subList(3, numbers.size());

        List<PointCoordinate> polygon = new ArrayList<>();

        for (int i = 0; i < part.size(); i+=2) {
            polygon.add(new PointCoordinate(part.get(i),part.get(i +1)));
        }


        System.out.print(isPointInPolygon(new PointCoordinate(first,second),polygon));



    }
    public static int isPointInPolygon(PointCoordinate point, List<PointCoordinate> polygon) {

        boolean res = false;
        int j= polygon.size()-1;


        for (int i = 0; i < polygon.size(); i++) {
            if ((((polygon.get(i).y < point.y) && (point.y < polygon.get(j).y)) || ((polygon.get(j).y <= point.y) && (point.y < polygon.get(i).y))) &&
                    (point.x > (polygon.get(j).x - polygon.get(i).x) * (point.y - polygon.get(i).y) / (polygon.get(j).y - polygon.get(i).y) + polygon.get(i).x))
                res = !res;
            j=i;
        }
        int ret = 0;
        if (res){
            ret = 1;
        } else {
            ret = 0;
        }

        return ret;
    }
}
