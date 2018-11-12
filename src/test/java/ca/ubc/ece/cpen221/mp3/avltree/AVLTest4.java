package ca.ubc.ece.cpen221.mp3.avltree;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class AVLTest4{
    private AvlTreeSet avltree;

    @Before
    public void AVLTest4() {
        avltree = new AvlTreeSet();
        avltree.insert(9);
        avltree.insert(1);
        avltree.insert(12);
        avltree.insert(13);
        avltree.insert(11);
        avltree.insert(14);
        avltree.insert(17);
        avltree.insert(2);
        avltree.insert(5);
        avltree.insert(10);
        avltree.insert(20);
        avltree.insert(3);
        avltree.insert(15);
        avltree.insert(4);
        avltree.insert(25);
        avltree.insert(18);
        avltree.insert(6);
    }

    @Test
    public void testEmpty() {
        boolean empty = avltree.isEmpty();
        assertFalse(empty);
    }

    @Test
    public void testSize() {
        int size = avltree.size();
        assertEquals(17, size);
    }

    @Test
    public void testHeight() {
        int height = avltree.getHeight();
        assertEquals(4, height);
    }

    @Test
    public void testContains() {
        boolean contains = avltree.contains(14);
        assertTrue(contains);
    }

    @Test
    public void checkMin() {
        int min = avltree.getMin();
        assertEquals(1, min);
    }

    @Test
    public void testMax() {
        int max = avltree.getMax();
        assertEquals(25, max);
    }

}

