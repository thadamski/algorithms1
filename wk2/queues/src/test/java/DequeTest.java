import junit.framework.TestCase;

import java.util.NoSuchElementException;

/**
 * Created by tadamski on 11/10/16.
 */
public class DequeTest extends TestCase {

    public void testDeque() {
        Deque<Integer> d = new Deque<>();
        assertTrue(d.isEmpty());

        try {
            d.removeFirst();
        } catch (NoSuchElementException nee) {
            assertTrue(true);
        }

        try {
            d.removeLast();
        } catch (NoSuchElementException nee) {
            assertTrue(true);
        }

        d.addLast(3);
        assertEquals(d.size(), 1);
        d.addFirst(2);
        assertEquals(d.size(), 2);
        d.addFirst(1);
        assertEquals(d.size(), 3);
        d.addLast(4);
        assertEquals(d.size(), 4);
        d.addLast(5);
        assertEquals(d.size(), 5);

        assertFalse(d.isEmpty());

        assertEquals("12345", mkString(d));

        assertSame(1, d.removeFirst());
        assertEquals(4, d.size());
        assertEquals("2345", mkString(d));

        assertSame(2, d.removeFirst());
        assertEquals(3, d.size());
        assertEquals("345", mkString(d));

        assertSame(5, d.removeLast());
        assertEquals(2, d.size());
        assertEquals("34", mkString(d));

        assertSame(4, d.removeLast());
        assertEquals(1, d.size());
        assertEquals("3", mkString(d));

        assertSame(3, d.removeFirst());
        assertEquals(0, d.size());
        assertEquals("", mkString(d));

        try {
            d.removeFirst();
        } catch (NoSuchElementException nee) {
            assertTrue(true);
        }

        try {
            d.removeLast();
        } catch (NoSuchElementException nee) {
            assertTrue(true);
        }
    }

    private String mkString(Deque<Integer> d) {
        String cat = "";
        for (Integer i : d) {
            cat = cat + i;
        }
        return cat;
    }

}
