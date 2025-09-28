package closest.algoritm;
import metrics.algoritm.Metrics;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static java.lang.Double.POSITIVE_INFINITY;
import static org.junit.jupiter.api.Assertions.*;

        import java.util.Random;

class PairClosestTest {

    private static double bruteForce(Point[] points) {
        double min = POSITIVE_INFINITY;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                min = Math.min(min, Point.distance(points[i], points[j]));
            }
        }
        return min;
    }

    @Test
    void testSimpleCase() {
        Point[] pts = { new Point(0, 0), new Point(3, 4), new Point(7, 1) };
        Metrics metrics = new Metrics();
        assertEquals(5.0,PairClosest.findClosest(pts, metrics), 1e-9);
    }

    @Test
    void testBruteComparisonSmall() {
        Random rand = new Random(42);
        Point[] pts = new Point[10];
        for (int i = 0; i < pts.length; i++) {
            pts[i] = new Point(rand.nextInt(100), rand.nextInt(100));
        }
        double expected = bruteForce(pts);
        Metrics metrics = new Metrics();
        double actual = PairClosest.findClosest(pts, metrics);
        assertEquals(expected, actual, 1e-9);
    }

    @Test
    void testBruteComparisonMedium() {
        Random rand = new Random(111);
        Point[] pts = new Point[200];
        for (int i = 0; i < pts.length; i++) {
            pts[i] = new Point(rand.nextDouble() * 1000, rand.nextDouble() * 1000);
        }
        double expected = bruteForce(pts);
        Metrics metrics = new Metrics();
        double actual = PairClosest.findClosest(pts, metrics);

    }
}