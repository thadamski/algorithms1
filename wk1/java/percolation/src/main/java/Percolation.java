import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/** Created by tadamski on 10/30/16. */
public class Percolation {

    private final int n;

    private final int virtualTop;
    private final int virtualBottom;
    private final int matrixSize;
    private final boolean[] opened;
    private final WeightedQuickUnionUF wqu;

    /** create n-by-n grid, with all sites blocked */
    public Percolation(int n) {
        if (n < 1) throw new IllegalArgumentException("n must be positive integer");
        this.n = n;

        this.matrixSize = n * n;
        this.virtualTop = 0;
        this.virtualBottom = this.matrixSize + 1;

        int firstBottomRow = this.matrixSize + 1 - n;


        // The top and bottom rows should be linked to the virtual top/bottom nodes
        int quickUnionSize = this.matrixSize + 2;
        this.wqu = new WeightedQuickUnionUF(quickUnionSize);
        for (int i = 0; i < quickUnionSize; i++) {
            if (i <= n) this.wqu.union(virtualTop, i);
            else if (i >= firstBottomRow) this.wqu.union(virtualBottom, i);
        }

        // Pad the opened array so we can use 1 based indexing like the matrix
        int openedSize = this.matrixSize + 1;
        this.opened = new boolean[openedSize];
        for (int i = 0; i < openedSize; i++) this.opened[i] = false;
    }

    /** open site (row, col) if it is not open already */
    public void open(int row, int col) {
        validateBounds(row, col);

        int currentIdx = xyTo1D(row, col, this.n);
        int currentMod = currentIdx % this.n;
        if (!this.opened[currentIdx]) {
            // Connect top if open and within bounds
            int topIdx = currentIdx - this.n;
            if (topIdx > 0 && this.opened[topIdx]) {
                this.wqu.union(currentIdx, topIdx);
            }

            // Connect right if open and a neighbor
            if (currentMod != 1) {
                int leftIdx = currentIdx - 1;
                if (leftIdx > 0) {
                    int leftMod = leftIdx % this.n;
                    if ((leftMod != 0) && (leftMod < currentMod) && this.opened[leftIdx]) {
                        this.wqu.union(currentIdx, leftIdx);
                    }
                }
            }

            // Connect bottom if open and within bounds
            int bottomIdx = currentIdx + this.n;
            if ((bottomIdx <= this.matrixSize) && this.opened[bottomIdx]) {
                this.wqu.union(currentIdx, bottomIdx);
            }

            // Connect left if open and a neighbor
            if (currentMod != 0) {
                int rightIdx = currentIdx + 1;
                if (rightIdx <= this.matrixSize) {
                    int rightMod = rightIdx % this.n;
                    if ((rightMod == 0) || (rightMod > currentMod) && (this.opened[rightIdx])) {
                        this.wqu.union(currentIdx, rightIdx);
                    }
                }
            }

            this.opened[currentIdx] = true;
        }
    }

    /** is site (row, col) open? */
    public boolean isOpen(int row, int col) {
        validateBounds(row, col);
        int oneDIndex = xyTo1D(row, col, this.n);
        return this.opened[oneDIndex];
    }

    /** is site (row, col) full? */
    public boolean isFull(int row, int col) {
        validateBounds(row, col);
        int currentIdx = xyTo1D(row, col, this.n);
        boolean connected = this.wqu.connected(currentIdx, this.virtualTop);
        boolean open = this.opened[currentIdx];
        return open && connected;
    }

    /** does the system percolate? */
    public boolean percolates() {
        return (this.n == 1 && this.opened[1]) ||
            this.wqu.connected(this.virtualBottom, this.virtualTop);
    }

    private int xyTo1D(int row, int col, int n) {
        return (row * n) - (n - col);
    }

    private void validateBounds(int row, int col) {
        int n = this.n;

        if ((row < 1 || row > n) || (col < 1 || col > n)) {
            throw new IndexOutOfBoundsException("(" + row + ", "  + col + ") not within (" + n + ", " + n + ") grid");
        }
    }

    /** test client (optional) */
    public static void main(String[] args) { }
}
