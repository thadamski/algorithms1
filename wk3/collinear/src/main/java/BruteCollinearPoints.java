import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by tadamski on 11/15/16.
 */
public class BruteCollinearPoints {

    private final List<LineSegment> lineSegmentsList = new ArrayList<>();
    private LineSegment[] lineSegments;

    private Stack<Point> pointStack = new Stack<>();
    private Double currentSlope;

    /** finds all line segments containing 4 points */
    public BruteCollinearPoints(Point[] points) {
        if (points == null) throw new NullPointerException();

        // Ensure all points are non-null
        for (Point p : points) {
            if (p == null) throw new NullPointerException();
        }

        assertNoDuplicates(points);

        Arrays.sort(points);

        int pointsLength = points.length;
        if (pointsLength > 4) {
            for (int i = 0; i < pointsLength - 3; i++) {
                for (int j = 1; j < pointsLength - 2; j++) {
                    for (int k = 2; k < pointsLength - 1; k++) {
                        for (int l = 3; l < pointsLength; l++) {
                            pointsToSegments(points[i], points[j], points[k], points[l]);
                        }
                    }
                }
            }

        }
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
        return this.segments().length;
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
        if (this.lineSegments == null) {
            Double slope = null;
            Point first = null;
            for (int i = 0; i < this.pointStack.size() - 1; i++) {
                for (int j = 1; j < this.pointStack.size(); j++) {
                    Point p0 = this.pointStack.pop();
                    Point p1 = this.pointStack.pop();
                }
            }
            this.lineSegments = this.lineSegmentsList.toArray(new LineSegment[this.lineSegmentsList.size()]);
        }
        return this.lineSegments;
    }

    private void pointsToSegments(Point p0, Point p1, Point p2, Point p3) {
        if (this.currentSlope != null) {
            this.currentSlope = p0.slopeTo(p1);
            if (p1.slopeTo(p2) == this.currentSlope && p2.slopeTo(p3) == this.currentSlope) {
                this.pointStack.push(p0);
                this.pointStack.push(p1);
            }
        } else {
            Point topPoint = this.pointStack.pop();
            if (topPoint.slopeTo(p0) == this.currentSlope) {
                if (p0.slopeTo(p1) == this.currentSlope) {
                    if (p1.slopeTo(p2) == this.currentSlope) {
                        if (p2.slopeTo(p3) == this.currentSlope) {
                            this.pointStack.push(p3);
                        } else {
                            this.pointStack.push(p2);
                        }
                    } else {
                        this.pointStack.push(p1);
                    }
                } else {
                    this.pointStack.push(p0);
                }
            } else {
                this.pointStack.push(topPoint);
            }
        }
    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

}
