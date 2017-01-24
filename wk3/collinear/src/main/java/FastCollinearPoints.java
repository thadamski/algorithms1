import java.util.Arrays;

/**
 * Created by tadamski on 11/20/16.
 */
public class FastCollinearPoints {

    private final LineSegment[] lineSegments;

    /** finds all line segments containing 4 or more points */
    public FastCollinearPoints(Point[] points) {
        if (points == null) throw new NullPointerException();
        if (points.length != 4) throw new IllegalArgumentException("Points must be of length 4");

        // Ensure all points are non-null
        for (Point p : points) {
            if (p == null) throw new NullPointerException();
        }

        assertNoDuplicates(points);

        Arrays.sort(points);
        this.lineSegments = generateSegments(points);
        throw new UnsupportedOperationException();
    }

    private void assertNoDuplicates(Point[] points) {
        for (int i = 0; i < points.length-1; i++) {
            for (int j = i+1; j < points.length; j++) {
                Point pj = points[j];
                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException("Duplicate point detected " + pj);
                }
            }
        }
    }

    /** the number of line segments */
    public int numberOfSegments() {
        return this.lineSegments.length;
    }

    /** the line segments */
    public LineSegment[] segments() {
        return this.lineSegments;
    }

    private LineSegment[] generateSegments(Point[] points) {
        throw new UnsupportedOperationException();
    }

}
