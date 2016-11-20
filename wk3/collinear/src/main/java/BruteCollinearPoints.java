/**
 * Created by tadamski on 11/15/16.
 */
public class BruteCollinearPoints {

    private final Point[] points;

    /** finds all line segments containing 4 points */
    public BruteCollinearPoints(Point[] points) {
        if (points == null) throw new NullPointerException();
        if (points.length != 4) throw new IllegalArgumentException("Points must be of length 4");

        // Ensure all points are non-null
        for (Point p : points) {
            if (p == null) throw new NullPointerException();
        }

        // Ensure there are no duplicate points
        throw new UnsupportedOperationException();
    }

    /** the number of line segments */
    public int numberOfSegments() {
        throw new UnsupportedOperationException();
    }

    /**
     * The line segments
     *
     * should include each line segment containing 4 points
     * exactly once. If 4 points appear on a line segment in
     * the order p→q→r→s, then you should include either the
     * line segment p→s or s→p (but not both) and you should
     * not include subsegments such as p→r or q→r. For
     * simplicity, we will not supply any input to
     * BruteCollinearPoints that has 5 or more collinear points.
     * */
    public LineSegment[] segments() {
        throw new UnsupportedOperationException();
    }
}