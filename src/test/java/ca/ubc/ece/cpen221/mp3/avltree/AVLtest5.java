package ca.ubc.ece.cpen221.mp3.avltree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AVLtest5{
    private AvlTreeSet avlTree;

    @Before
    public void AVLtest5() {
        avlTree = new AvlTreeSet();
        avlTree.insert(9);
        avlTree.insert(1);
        avlTree.insert(12);
        avlTree.insert(14);
        avlTree.insert(13);
    }

    @Test
    public void testEmpty() {
        boolean empty = avlTree.isEmpty();
        assertFalse(empty);
    }

    @Test
    public void testSize() {
        int size = avlTree.size();
        assertEquals(5, size);
    }

    @Test
    public void testHeight() {
        int height = avlTree.getHeight();
        assertEquals(2, height);
    }

    @Test
    public void testContains() {
        boolean test = avlTree.contains(13);
        assertTrue(test);
    }
    @Test
    public void testContains2() {
        boolean test = avlTree.contains(11);
        assertFalse(test);
    }

    @Test
    public void testContains3() {
        boolean test = avlTree.contains(12);
        assertTrue(test);
    }

    @Test
    public void testContains4() {
        boolean test = avlTree.contains(9);
        assertTrue(test);
    }

    @Test
    public void testContains5() {
        boolean test = avlTree.contains(1);
        assertTrue(test);
    }

    @Test
    public void testContains7() {
        boolean test = avlTree.contains(14);
        assertTrue(test);
    }

    @Test
    public void testContains6() {
        boolean test = avlTree.contains(2);
        assertFalse(test);
    }

    @Test
    public void testMin() {
        int min = avlTree.getMin();
        assertEquals(1, min);
    }

    @Test
    public void testMax() {
        int max = avlTree.getMax();
        assertEquals(14, max);
    }

}


