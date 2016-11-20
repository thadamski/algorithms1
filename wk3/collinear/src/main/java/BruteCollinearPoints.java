import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by tadamski on 11/15/16.
 */
public class BruteCollinearPoints {

    private final LineSegment[] lineSegments;

    /** finds all line segments containing 4 points */
    public BruteCollinearPoints(Point[] points) {
        if (points == null) throw new NullPointerException();
        if (points.length != 4) throw new IllegalArgumentException("Points must be of length 4");

        // Ensure all points are non-null
        for (Point p : points) {
            if (p == null) throw new NullPointerException();
        }

        assertNoDuplicates(points);

        Arrays.sort(points);
        this.lineSegments = compressSegments(generateSegments(points));
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
        return this.lineSegments;
    }

    private LineSegment[] generateSegments(Point[] points) {
        Stack<Point> ps = new Stack<>();
        Point p0 = points[0];
        Point p1 = points[1];
        ps.push(p0);
        ps.push(p1);

        double slope = p0.slopeTo(p1);
        for (int i = 2; i < points.length; i++) {
            Point top = ps.pop();
            Point nextPoint = points[i];
            if (top.slopeTo(nextPoint) != slope) break;
            else {
                ps.push(nextPoint);
            }
        }

        if (ps.size() == 2) {
            Point last = ps.pop();
            Point first = ps.pop();
            LineSegment[] ls = new LineSegment[1];
            ls[0] = new LineSegment(first, last);
            return ls;
        } else {
            return new LineSegment[0];
        }
    }

    private LineSegment[] compressSegments(LineSegment[] segments) {

        return segments;
    }

}