import junit.framework.TestCase;

import java.util.Comparator;

/**
 * Created by tadamski on 11/20/16.
 */
public class PointTest extends TestCase {

    private static final int GREATER_THAN = 1;
    private static final int EQUAL = 0;
    private static final int LESS_THAN = -1;

    public void testComparable() {
        assertEquals(LESS_THAN, new Point(0, 1).compareTo(new Point(0, 2)));
        assertEquals(EQUAL, new Point(0, 1).compareTo(new Point(0, 1)));
        assertEquals(GREATER_THAN, new Point(0, 1).compareTo(new Point(0, 0)));

        assertEquals(GREATER_THAN, new Point(-10, 10).compareTo(new Point(100, 9)));
        assertEquals(GREATER_THAN, new Point(-10, 10).compareTo(new Point(-10, 9)));
        assertEquals(EQUAL, new Point(-10, 10).compareTo(new Point(-10, 10)));
        assertEquals(LESS_THAN, new Point(-10, 10).compareTo(new Point(-10, 11)));
    }

    public void testSlopeTo() {
        assertEquals(1d, new Point(0, 0).slopeTo(new Point(1, 1)));
        assertEquals(-0.5d, new Point(0, 3).slopeTo(new Point(4, 1)));
        assertEquals(0.25d, new Point(1, 1).slopeTo(new Point(-3, 0)));
        assertEquals(-2d / 3d, new Point(0, 1).slopeTo(new Point(3, -1)));
        assertEquals(2d / 3d, new Point(3, -2).slopeTo(new Point(6, 0)));

        // Horizontal Line
        assertEquals(Point.POSITIVE_ZERO, new Point(1, 3).slopeTo(new Point(8, 3)));
        assertEquals(Point.POSITIVE_ZERO, new Point(-3, 0).slopeTo(new Point(-2, 0)));
        assertEquals(Point.POSITIVE_ZERO, new Point(0, -1).slopeTo(new Point(100, -1)));

        // Vertical Lines
        assertEquals(Double.POSITIVE_INFINITY, new Point(1, 3).slopeTo(new Point(1, 4)));
        assertEquals(Double.POSITIVE_INFINITY, new Point(-1, 4).slopeTo(new Point(-1, -2)));
        assertEquals(Double.POSITIVE_INFINITY, new Point(0, 0).slopeTo(new Point(0, -2)));
        assertEquals(Double.POSITIVE_INFINITY, new Point(0, 4).slopeTo(new Point(0, -1)));

        // Degenerate Lines (Same coordinate)
        assertEquals(Double.NEGATIVE_INFINITY, new Point(0, 0).slopeTo(new Point(0, 0)));
        assertEquals(Double.NEGATIVE_INFINITY, new Point(1, -1).slopeTo(new Point(1, -1)));
        assertEquals(Double.NEGATIVE_INFINITY, new Point(-2, 0).slopeTo(new Point(-2, 0)));
        assertEquals(Double.NEGATIVE_INFINITY, new Point(0, 3).slopeTo(new Point(0, 3)));
    }

    public void testSlopeOrderComparator() {
        Comparator<Point> p = new Point(0, 0).slopeOrder();
        assertEquals(GREATER_THAN, p.compare(new Point(1, 2), new Point(2, 2)));
        assertEquals(LESS_THAN, p.compare(new Point(2, 2), new Point(1, 2)));

        assertEquals(EQUAL, p.compare(new Point(2, 2), new Point(2, 2)));
        assertEquals(EQUAL, p.compare(new Point(0, 0), new Point(0, 0)));
        assertEquals(EQUAL, p.compare(new Point(1, 0), new Point(2, 0)));
        assertEquals(EQUAL, p.compare(new Point(0, 1), new Point(0, 2)));
    }
}
