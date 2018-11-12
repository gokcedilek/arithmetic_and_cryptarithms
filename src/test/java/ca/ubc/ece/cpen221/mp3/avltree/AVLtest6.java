package ca.ubc.ece.cpen221.mp3.avltree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AVLtest6{
    private AvlTreeSet avlTree;

    @Before
    public void AVLtest6() {
        avlTree = new AvlTreeSet();
        avlTree.insert(9);
        avlTree.insert(8);
        avlTree.insert(7);
        avlTree.insert(6);
        avlTree.insert(5);
        avlTree.insert(4);
    }

    @Test
    public void testEmpty() {
        boolean empty = avlTree.isEmpty();
        assertFalse(empty);
    }

    @Test
    public void testSize() {
        int size = avlTree.size();
        assertEquals(6, size);
    }

    @Test
    public void testHeight() {
        int height = avlTree.getHeight();
        assertEquals(2, height);
    }

    @Test
    public void testContains() {
        boolean contains = avlTree.contains(6);
        assertTrue(contains);
    }
    @Test
    public void testContains2() {
        boolean contains = avlTree.contains(11);
        assertFalse(contains);
    }

    @Test
    public void testContains3() {
        boolean contains = avlTree.contains(5);
        assertTrue(contains);
    }

    @Test
    public void testContains4() {
        boolean contains = avlTree.contains(9);
        assertTrue(contains);
    }

    @Test
    public void testContains6() {
        boolean contains = avlTree.contains(2);
        assertFalse(contains);
    }

    @Test
    public void testMin() {
        int min = avlTree.getMin();
        assertEquals(4, min);
    }

    @Test
    public void testMax() {
        int max = avlTree.getMax();
        assertEquals(9, max);
    }

}

