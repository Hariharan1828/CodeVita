import java.util.Scanner;

public class onACube {

    static class Point {
        double x;
        double y;
        double z;

        Point(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

    }

    static double calculateDistance(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point2.x - point1.x, 2) + Math.pow(point2.y - point1.y, 2) + Math.pow(point2.z - point1.z, 2));
    }

    static double calculateSamePlaneDistance(Point point1, Point point2) {
        double distance = calculateDistance(point1, point2);
        double radius = 5.0;
        double angle = Math.toDegrees(2 * Math.asin(distance / (2 * radius)));
        return Math.PI * radius * (angle / 360.0);
    }

    static double findTotalDistance(Point[] points, int n) {
        double totalDistance = 0;

        for (int i = 0; i < n - 1; i++) {
            Point currentPoint = points[i];
            Point nextPoint = points[i + 1];

            if (currentPoint.z == nextPoint.z) {
                totalDistance += calculateSamePlaneDistance(currentPoint, nextPoint);
            } else {
                totalDistance += calculateDistance(currentPoint, nextPoint);
            }
        }

        return totalDistance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            double z = scanner.nextDouble();
            points[i] = new Point(x, y, z);
        }

        double ans = findTotalDistance(points, n);
        System.out.printf("%.2f", ans);
    }
}