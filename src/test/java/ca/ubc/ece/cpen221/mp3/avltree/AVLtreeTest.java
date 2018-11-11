package ca.ubc.ece.cpen221.mp3.avltree;
import static org.junit.Assert.*;
import ca.ubc.ece.cpen221.mp3.avltree.AvlTreeSet;
import org.junit.Test;
import org.junit.Before;

public class AVLtreeTest {
    private AvlTreeSet avltree;

    @Before
    public void AVLtreeTest() {
        avltree = new AvlTreeSet();
    }

    @Test
    public void testEmpty() {
        boolean empty = avltree.isEmpty();
        assertTrue(empty);
    }


    @Test
    public void testContains() {
        boolean contains = avltree.contains(9);
        assertFalse(contains);
    }


    @Test
    public void testMinThrowsIllegalStateException() {
        boolean thrown = false;

        try {
            int min = avltree.getMin();
        } catch (IllegalStateException e) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    @Test
    public void testMaxThrowsIllegalStateException() {
        boolean thrown = false;

        try {
            int max = avltree.getMax();
        } catch (IllegalStateException e) {
            thrown = true;
        }

        assertTrue(thrown);
    }


    @Test
    public void testSize() {
        int size = avltree.size();
        assertEquals(0, size);
    }

    @Test
    public void testHeight() {
        int height = avltree.getHeight();
        assertEquals(-1, height);
    }

}
