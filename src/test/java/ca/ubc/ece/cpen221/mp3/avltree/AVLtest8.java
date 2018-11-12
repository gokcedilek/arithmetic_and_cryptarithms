package ca.ubc.ece.cpen221.mp3.avltree;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class AVLtest8 {
    private AvlTreeSet avltree = new AvlTreeSet();

    @Before
    public void AVLtest8() {
        avltree = new AvlTreeSet();
        avltree.insert(9);
        avltree.insert(9);
        avltree.insert(9);
        avltree.insert(9);
        avltree.insert(9);
        avltree.remove(9);
    }

    @Test
    public void testEmpty() {
        boolean test = avltree.isEmpty();
        assertTrue(test);
    }

    @Test
    public void testHeight() {
        int height = avltree.getHeight();
        assertEquals(-1, height);
    }

    @Test
    public void testContains() {
        boolean test = avltree.contains(9);
        assertFalse(test);
    }
}
