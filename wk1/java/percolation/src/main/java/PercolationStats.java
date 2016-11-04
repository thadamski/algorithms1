import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/** Created by tadamski on 11/1/16. */
@SuppressWarnings("WeakerAccess")
public class PercolationStats {

    private final int n;
    private final int trials;
    private final double mean;
    private final double stddev;

    /** perform trials independent experiments on an n-by-n grid */
    public PercolationStats(int n, int trials) {
        if (n <= 0) throw new IllegalArgumentException("n <= 0");
        if (trials <= 0) throw new IllegalArgumentException("trials <= 0");

        this.trials = trials;
        this.n = n;

        double [] percolationThresholds = new double[trials];
        int gridSize = n * n;

        for (int i = 0; i < trials; i++) {
            // state variable to track how many sites are open
            double opened = 0d;
            Percolation p = new Percolation(n);

            while (!p.percolates()) {
                Site<Integer, Integer> site = findRandomClosedSite(p);
                p.open(site.row, site.col);
                opened++;
            }

            double percolationThreshold = opened / gridSize;
            percolationThresholds[i] = percolationThreshold;
        }

        /* Mean */
        this.mean = StdStats.mean(percolationThresholds);

        /* Standard Deviation */
        if (this.trials == 1) this.stddev = Double.NaN;
        else {
            this.stddev = StdStats.stddev(percolationThresholds);
        }
    }

    private Site<Integer,Integer> findRandomClosedSite(Percolation p) {
        Integer row = StdRandom.uniform(1, this.n);
        Integer col = StdRandom.uniform(1, this.n);
        while (p.isOpen(row, col)) {
            row = StdRandom.uniform(1, this.n);
            col = StdRandom.uniform(1, this.n);
        }

        return new Site<>(row, col);
    }

    /** sample mean of percolation threshold */
    public double mean() {
        return this.mean;
    }

    /** sample standard deviation of percolation threshold */
    public double stddev() {
        return this.stddev;
    }

    /** low  endpoint of 95% confidence interval */
    public double confidenceLo() {
        return this.mean - ((1.96d * this.stddev) / Math.sqrt(this.trials));
    }

    /** high endpoint of 95% confidence interval */
    public double confidenceHi() {
        return this.mean + ((1.96d * this.stddev) / Math.sqrt(this.trials));
    }

    /** test client (described below) */
    public static void main(String[] args) {
        if (args.length != 2) throw new IllegalArgumentException("Must provide 2 command line arguments");
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        PercolationStats ps = new PercolationStats(n, trials);

        double mean = ps.mean();
        double stddev = ps.stddev();
        double confidenceLow = ps.confidenceLo();
        double confidenceHi = ps.confidenceHi();

        StdOut.println("mean = " + mean);
        StdOut.println("stddev = " + stddev);
        StdOut.println("95% confidence interval = " + confidenceLow + ", " + confidenceHi);
    }

    public class Site<Row, Col> {
        public final Row row;
        public final Col col;

        public Site(Row row, Col col) {
            this.row = row;
            this.col = col;
        }
    }
}

