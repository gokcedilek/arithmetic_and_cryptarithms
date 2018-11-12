package ca.ubc.ece.cpen221.mp3.avltree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AVLTest9 {
    private AvlTreeSet avltree;

    @Before
    public void AVLtreeTest() {
        avltree = new AvlTreeSet();
        this.avltree.insert(9);
        this.avltree.insert(1);
        this.avltree.insert(12);
    }

    @Test
    public void testEmpty() {
        boolean empty = avltree.isEmpty();
        assertFalse(empty);
    }


    @Test
    public void testContains() {
        boolean contains = avltree.contains(9);
        assertTrue(contains);
    }

    @Test
    public void testContains2() {
        boolean contains = avltree.contains(12);
        assertTrue(contains);
    }


    @Test
    public void testMin() {
        int min = avltree.getMin();
        assertEquals(1, min);
    }

    @Test
    public void testMax() {
        int max = avltree.getMax();
        assertEquals(12, max);
    }

    @Test
    public void testSize() {
        int size = avltree.size();
        assertEquals(3, size);
    }

    @Test
    public void testHeight() {
        int height = avltree.getHeight();
        assertEquals(2, height);
    }

}
