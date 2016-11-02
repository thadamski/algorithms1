package org.coursera.algorithms.qf;

import junit.framework.TestCase;
import org.junit.Test;

public class QuickUnionTest extends TestCase {

  @Test
  public void testQuickUnion() {
    QuickUnion qu = new QuickUnion(10);
      qu.union(4, 3);
      qu.union(3, 8);
      qu.union(6, 5);
      qu.union(9, 4);
      qu.union(2, 1);

      assertFalse(qu.connected(2, 8));
      assertFalse(qu.connected(6, 7));
      assertTrue(qu.connected(0, 0));
      assertTrue(qu.connected(3, 4));

      qu.union(5, 0);
      qu.union(7, 2);
      qu.union(6, 1);
      qu.union(7, 3);

      assertTrue(qu.connected(2, 8));
      assertTrue(qu.connected(6, 7));
      assertTrue(qu.connected(0, 0));
      assertTrue(qu.connected(3, 4));
  }

}
