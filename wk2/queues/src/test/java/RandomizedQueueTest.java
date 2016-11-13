import junit.framework.TestCase;

import java.util.*;

/**
 * Created by tadamski on 11/13/16.
 */
public class RandomizedQueueTest extends TestCase {

    public void testRandomizedQueue() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();

        try {
            rq.dequeue();
        } catch (NoSuchElementException nse) {
            assertTrue(true);
        }

        try {
            rq.sample();
        } catch (NoSuchElementException nse) {
            assertTrue(true);
        }

        assertEquals(0, rq.size());
        assertTrue(rq.isEmpty());

        rq.enqueue(10);

        assertEquals(1, rq.size());
        assertFalse(rq.isEmpty());
        assertSame(10, rq.sample());

        rq.enqueue(20);

        assertEquals(2, rq.size());
        assertFalse(rq.isEmpty());
        assertTrue(containsAll(Arrays.asList(10, 20), rq));
        assertTrue(containsAll(Arrays.asList(10, 20), rq));
        assertTrue(containsAll(Arrays.asList(10, 20), rq));

        rq.enqueue(30);
        assertEquals(3, rq.size());
        assertFalse(rq.isEmpty());
        assertTrue(containsAll(Arrays.asList(10, 20, 30), rq));

        rq.dequeue();
        assertEquals(2, rq.size());
        assertFalse(rq.isEmpty());
        assertTrue(containsAll(Arrays.asList(10, 20, 30), rq));

        rq.dequeue();
        assertEquals(1, rq.size());
        assertFalse(rq.isEmpty());
        assertTrue(containsAll(Arrays.asList(10, 20, 30), rq));

        rq.dequeue();
        assertEquals(0, rq.size());
        assertTrue(rq.isEmpty());
    }

    private boolean containsAll(List<Integer> expected, RandomizedQueue<Integer> actual) {
        for (Integer i : actual) {
            if (!expected.contains(i)) {
                return false;
            }
        }
        return true;
    }

}
