import junit.framework.TestCase;

/** Created by tadamski on 11/5/16. */
public class PercolationTest extends TestCase {

    public void testInput6() {
        Percolation p = new Percolation(6);
        p.open(1, 6);
        assertTrue(p.isOpen(1, 6));
        assertFalse(p.percolates());
        assertTrue(p.isFull(1, 6));

        p.open(2, 6);
        assertTrue(p.isOpen(2, 6));
        assertFalse(p.percolates());
        assertTrue(p.isFull(2, 6));

        p.open(3, 6);
        assertTrue(p.isOpen(3, 6));
        assertFalse(p.percolates());
        assertTrue(p.isFull(3, 6));

        p.open(4, 6);
        assertTrue(p.isOpen(4, 6));
        assertFalse(p.percolates());
        assertTrue(p.isFull(4, 6));

        p.open(5, 6);
        assertTrue(p.isOpen(5, 6));
        assertFalse(p.percolates());
        assertTrue(p.isFull(5, 6));

        p.open(5, 5);
        assertTrue(p.isOpen(5, 5));
        assertFalse(p.percolates());
        assertTrue(p.isFull(5, 5));

        p.open(4, 4);
        assertTrue(p.isOpen(4, 4));
        assertFalse(p.percolates());
        assertFalse(p.isFull(4, 4));

        p.open(3, 4);
        assertTrue(p.isOpen(3, 4));
        assertFalse(p.percolates());
        assertFalse(p.isFull(3, 4));

        p.open(2, 4);
        assertTrue(p.isOpen(2, 4));
        assertFalse(p.percolates());
        assertFalse(p.isFull(2, 4));

        p.open(2, 3);
        assertTrue(p.isOpen(2, 3));
        assertFalse(p.percolates());
        assertFalse(p.isFull(2, 3));

        p.open(2, 2);
        assertTrue(p.isOpen(2, 2));
        assertFalse(p.percolates());
        assertFalse(p.isFull(2, 2));

        p.open(2, 1);
        assertTrue(p.isOpen(2, 1));
        assertFalse(p.percolates());
        assertFalse(p.isFull(2, 1));

        p.open(3, 1);
        assertTrue(p.isOpen(3, 1));
        assertFalse(p.percolates());
        assertFalse(p.isFull(3, 1));

        p.open(4, 1);
        assertTrue(p.isOpen(4, 1));
        assertFalse(p.percolates());
        assertFalse(p.isFull(4, 1));

        p.open(5, 1);
        assertTrue(p.isOpen(5, 1));
        assertFalse(p.percolates());
        assertFalse(p.isFull(5, 1));

        p.open(5, 2);
        assertTrue(p.isOpen(5, 2));
        assertFalse(p.percolates());
        assertFalse(p.isFull(5, 2));

        p.open(6, 2);
        assertTrue(p.isOpen(6, 2));
        assertFalse(p.percolates());
        assertFalse(p.isFull(6, 2));

        p.open(5, 4);
        assertTrue(p.isOpen(5, 4));
        assertTrue(p.percolates());
        assertTrue(p.isFull(5, 4));
    }

}
