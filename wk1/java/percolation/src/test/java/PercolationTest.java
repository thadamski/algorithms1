import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by tadamski on 10/31/16.
 */
public class PercolationTest extends TestCase {

    @Test
    public void testConnection() {
        Percolation p = new Percolation(5);
        p.open(1, 1);
        p.open(1, 2);
        assertTrue(p.connected(1, 2));
    }

    @Test
    public void testxyTo1D() {
        Percolation p = new Percolation(20);
        assertEquals(41, p.xyTo1D(3, 1, 20));
    }

}
