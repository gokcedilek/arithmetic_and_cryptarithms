package ca.ubc.ece.cpen221.mp3.avltree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AVLtest7{
    private AvlTreeSet avlTree;

    @Before
    public void AVLtest7() {
        avlTree = new AvlTreeSet();
        avlTree.insert(9);
        avlTree.insert(1);
        avlTree.insert(2);
        avlTree.insert(8);
        avlTree.insert(13);
        avlTree.remove(8);
    }

    @Test
    public void testEmpty() {
        boolean empty = avlTree.isEmpty();
        assertFalse(empty);
    }

    @Test
    public void testSize() {
        int size = avlTree.size();
        assertEquals(4, size);
    }

    @Test
    public void testHeight() {
        int height = avlTree.getHeight();
        assertEquals(2, height);
    }

    @Test
    public void testContains() {
        boolean contains = avlTree.contains(13);
        assertTrue(contains);
    }
    @Test
    public void testContains2() {
        boolean contains = avlTree.contains(11);
        assertFalse(contains);
    }

    @Test
    public void testContains4() {
        boolean contains = avlTree.contains(8);
        assertFalse(contains);
    }

    @Test
    public void testContains5() {
        boolean contains = avlTree.contains(1);
        assertTrue(contains);
    }

    @Test
    public void testMin() {
        int min = avlTree.getMin();
        assertEquals(1, min);
    }

    @Test
    public void testMax() {
        int max = avlTree.getMax();
        assertEquals(13, max);
    }

}
