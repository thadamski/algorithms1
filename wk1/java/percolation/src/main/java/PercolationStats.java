/**
 * Created by tadamski on 11/1/16.
 */
public class PercolationStats {

    /** perform trials independent experiments on an n-by-n grid */
    public PercolationStats(int n, int trials) {
        if (n <= 0) throw new IllegalArgumentException("n <= 0");
        if (trials <= 0) throw new IllegalArgumentException("trials <= 0");

        throw new UnsupportedOperationException();
    }

    /** sample mean of percolation threshold */
    public double mean() {
        throw new UnsupportedOperationException();
    }

    /** sample standard deviation of percolation threshold */
    public double stddev() {
        throw new UnsupportedOperationException();
    }

    /** low  endpoint of 95% confidence interval */
    public double confidenceLo() {
        throw new UnsupportedOperationException();
    }

    /** high endpoint of 95% confidence interval */
    public double confidenceHi() {
        throw new UnsupportedOperationException();
    }

    /** test client (described below) */
    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }
}
