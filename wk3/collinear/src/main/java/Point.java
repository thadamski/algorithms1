import java.util.Comparator;

/** Created by tadamski on 11/15/16. */
public class Point implements Comparable<Point> {

    /** constructs the point (x, y) */
    public Point(int x, int y) {
        throw new UnsupportedOperationException();
    }

    /** draws the point */
    public void draw() {
        throw new UnsupportedOperationException();
    }

    /** draws the line segment from this point to that point */
    public void drawTo(Point that) {
        throw new UnsupportedOperationException();
    }

    /** string representation */
    public String toString() {
        throw new UnsupportedOperationException();
    }

    /** compare two points by y-coordinates, breaking ties by x-coordinates */
    public int compareTo(Point that) {
        throw new UnsupportedOperationException();
    }

    /** the slope between this point and that point */
    public double slopeTo(Point that) {
        throw new UnsupportedOperationException();
    }

    /** compare two points by slopes they make with this point */
    public Comparator<Point> slopeOrder() {
        throw new UnsupportedOperationException();
    }

}