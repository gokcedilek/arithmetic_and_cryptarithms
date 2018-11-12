package ca.ubc.ece.cpen221.mp3.avltree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AVLTest3{
    private AvlTreeSet avltree;

    @Before
    public void AVLTest3() {
        avltree = new AvlTreeSet();
        avltree.insert(9);
        avltree.insert(1);
        avltree.insert(12);
        avltree.insert(13);
        avltree.insert(11);
        avltree.insert(14);
        avltree.remove(12);
    }

    @Test
    public void testEmpty() {
        boolean empty = avltree.isEmpty();
        assertFalse(empty);
    }

    @Test
    public void testSize() {
        int size = avltree.size();
        assertEquals(5, size);
    }

    @Test
    public void testHeight() {
        int height = avltree.getHeight();
        assertEquals(2, height);
    }

    @Test
    public void testContains() {
        boolean test = avltree.contains(12);
        assertFalse(test);
    }

    @Test
    public void testMin(){
        int min = avltree.getMin();
        assertEquals(1, min);
    }

    @Test
    public void testMax() {
        int max = avltree.getMax();
        assertEquals(14, max);
    }

}

