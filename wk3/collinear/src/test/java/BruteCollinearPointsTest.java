import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tadamski on 11/20/16.
 */
public class BruteCollinearPointsTest extends TestCase {

    public void testAllPointsEqual() {
        Point[] ps = {
            new Point(0, 0),
            new Point(0, 0),
            new Point(0, 0),
            new Point(0, 0)
        };

        try {
            new BruteCollinearPoints(ps);
        } catch (IllegalArgumentException iae) {
            assertTrue(true);
        }
    }

    public void testHorizontalLine() {
        Point[] ps = {
                new Point(2, 0),
                new Point(1, 0),
                new Point(0, 0),
                new Point(-1, 0)
        };

        BruteCollinearPoints bcp = new BruteCollinearPoints(ps);
        assertEquals(1, bcp.numberOfSegments());
        List<String> lineSegments = Arrays.asList(
            new LineSegment(new Point(-1, 0), new Point(2, 0)).toString()
        );
        assertTrue(containsAll(bcp, lineSegments));
    }

    public void testVerticalLine() {
        Point[] ps = {
                new Point(0, 0),
                new Point(0, 1),
                new Point(0, 2),
                new Point(0, -1)
        };

        BruteCollinearPoints bcp = new BruteCollinearPoints(ps);
        assertEquals(1, bcp.numberOfSegments());
        List<String> lineSegments = Arrays.asList(
            new LineSegment(new Point(0, -1), new Point(0, 2)).toString()
        );
        assertTrue(containsAll(bcp, lineSegments));
    }

    public void testSlopeOfOneLine() {
        Point[] ps = {
                new Point(-1, -1),
                new Point(0, 0),
                new Point(1, 1),
                new Point(2, 2)
        };

        BruteCollinearPoints bcp = new BruteCollinearPoints(ps);
        assertEquals(1, bcp.numberOfSegments());
        List<String> lineSegments = Arrays.asList(
            new LineSegment(new Point(-1, -1), new Point(2, 2)).toString()
        );
        assertTrue(containsAll(bcp, lineSegments));
    }

    public void testLineSegmentsNoDuplicates() {
        Point[] ps = {
                new Point(0, 0),
                new Point(1, 10),
                new Point(2, 7),
                new Point(3, 8)
        };

        BruteCollinearPoints bcp = new BruteCollinearPoints(ps);
        assertEquals(0, bcp.numberOfSegments());
        assertEquals(0, bcp.segments().length);
    }

    public void testLineSegmentsWithDuplicates() {
        Point[] ps = {
                new Point(1, 1),
                new Point(2, 3),
                new Point(4, 3),
                new Point(3, 5)
        };

        BruteCollinearPoints bcp = new BruteCollinearPoints(ps);
        assertEquals(0, bcp.numberOfSegments());
    }

    private boolean containsAll(BruteCollinearPoints bcp, List<String> ls) {
        boolean matches = false;
        for (LineSegment s : bcp.segments()) {
            if (!ls.contains(s.toString())) {
                return false;
            }
        }
        return true;
    }

}
