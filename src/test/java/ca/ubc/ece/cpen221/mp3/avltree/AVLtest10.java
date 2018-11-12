package ca.ubc.ece.cpen221.mp3.avltree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AVLtest10{
    private AvlTreeSet avlTree;

    @Before
    public void AVLtest10() {
        avlTree = new AvlTreeSet();
        avlTree.insert(9);
        avlTree.insert(8);
        avlTree.insert(7);
        avlTree.insert(6);
        avlTree.remove(7);

    }

    @Test
    public void testEmpty() {
        boolean empty = avlTree.isEmpty();
        assertFalse(empty);
    }

    @Test
    public void testSize() {
        int size = avlTree.size();
        assertEquals(3, size);
    }

    @Test
    public void testHeight() {
        int height = avlTree.getHeight();
        assertEquals(1, height);
    }

    @Test
    public void testContains() {
        boolean contains = avlTree.contains(7);
        assertFalse(contains);
    }

    @Test
    public void testMinThrowsIllegalStateException() {
        boolean thrown = false;

        try {
            avlTree.remove(30);
        } catch (IllegalStateException e) {
            thrown = true;
        }

        assertTrue(thrown);
    }


}
