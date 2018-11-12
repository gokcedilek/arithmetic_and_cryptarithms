package ca.ubc.ece.cpen221.mp3.crypta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import ca.ubc.ece.cpen221.mp3.operator.*;
import ca.ubc.ece.cpen221.mp3.parser.ExpressionMaker;
import ca.ubc.ece.cpen221.mp3.permutation.Permutation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;

public class Tests {

    @Test
    public void test1() {

        List<String> perm = new ArrayList<>();
        perm.add("A");
        perm.add("B");
        perm.add("C");
        Permutation<String> p1 = new Permutation(perm);
        Set<List<String>> test = new HashSet<List<String>>();
        List<String> perm2 = new ArrayList<>();
        perm2.add("A");
        perm2.add("C");
        perm2.add("B");
        List<String> perm3 = new ArrayList<>();
        perm3.add("B");
        perm3.add("C");
        perm3.add("A");
        List<String> perm4 = new ArrayList<>();
        perm4.add("B");
        perm4.add("A");
        perm4.add("C");
        List<String> perm5 = new ArrayList<>();
        perm5.add("C");
        perm5.add("A");
        perm5.add("B");
        List<String> perm6 = new ArrayList<>();
        perm6.add("C");
        perm6.add("B");
        perm6.add("A");
        test.add(perm);
        test.add(perm2);
        test.add(perm3);
        test.add(perm4);
        test.add(perm5);
        test.add(perm6);
        p1.permute(perm, 0, 2);
        Set<List<String>> test1 = new HashSet<List<String>>();
        for (List<String> l : p1.getAllPermutations()) {
            test1.add(l);
        }

        assertEquals(test, test1);
    }

    @Test
    public void test2() {

        List<String> perm = new ArrayList<>();
        perm.add("A");
        perm.add("B");
        perm.add("C");
        perm.add("A");
        Permutation<String> p1 = new Permutation(perm);
        Set<List<String>> test = new HashSet<List<String>>();
        List<String> perm2 = new ArrayList<>();
        perm2.add("A");
        perm2.add("C");
        perm2.add("B");
        perm2.add("A");
        List<String> perm3 = new ArrayList<>();
        perm3.add("B");
        perm3.add("C");
        perm3.add("A");
        perm3.add("A");
        List<String> perm4 = new ArrayList<>();
        perm4.add("B");
        perm4.add("A");
        perm4.add("C");
        perm4.add("A");
        List<String> perm5 = new ArrayList<>();
        perm5.add("C");
        perm5.add("A");
        perm5.add("B");
        perm5.add("A");
        List<String> perm6 = new ArrayList<>();
        perm6.add("C");
        perm6.add("B");
        perm6.add("A");
        perm6.add("A");
        List<String> perm7 = new ArrayList<>();
        perm7.add("C");
        perm7.add("A");
        perm7.add("A");
        perm7.add("B");
        List<String> perm8 = new ArrayList<>();
        perm8.add("B");
        perm8.add("A");
        perm8.add("A");
        perm8.add("C");
        List<String> perm9 = new ArrayList<>();
        perm9.add("A");
        perm9.add("C");
        perm9.add("A");
        perm9.add("B");
        List<String> perm10 = new ArrayList<>();
        perm10.add("A");
        perm10.add("B");
        perm10.add("C");
        perm10.add("A");
        List<String> perm11 = new ArrayList<>();
        perm11.add("A");
        perm11.add("B");
        perm11.add("A");
        perm11.add("C");
        List<String> perm12 = new ArrayList<>();
        perm12.add("A");
        perm12.add("A");
        perm12.add("C");
        perm12.add("B");
        List<String> perm13 = new ArrayList<>();
        perm13.add("A");
        perm13.add("A");
        perm13.add("B");
        perm13.add("C");
        test.add(perm);
        test.add(perm2);
        test.add(perm3);
        test.add(perm4);
        test.add(perm5);
        test.add(perm6);
        test.add(perm7);
        test.add(perm8);
        test.add(perm9);
        test.add(perm10);
        test.add(perm11);
        test.add(perm12);
        test.add(perm13);
        p1.permute(perm, 0, 3);
        Set<List<String>> test1 = new HashSet<List<String>>();
        for (List<String> l : p1.getAllPermutations()) {
            test1.add(l);
        }

        assertEquals(test, test1);
    }

    @Test
    public void test3() {

        List<String> perm = new ArrayList<>();
        perm.add("A");
        perm.add("A");
        perm.add("A");
        perm.add("A");
        Permutation<String> p1 = new Permutation(perm);
        Set<List<String>> test = new HashSet<List<String>>();
        test.add(perm);
        p1.permute(perm, 0, 3);
        Set<List<String>> test1 = new HashSet<List<String>>();
        for (List<String> l : p1.getAllPermutations()) {
            test1.add(l);
        }

        assertEquals(test, test1);
    }
    @Test
    public void test4() {

        List<String> perm = new ArrayList<>();
        perm.add("R");
        perm.add("R");
        perm.add("R");
        perm.add("G");
        perm.add("G");
        Permutation<String> p1 = new Permutation(perm);
        Set<List<String>> test = new HashSet<List<String>>();
        List<String> perm2 = new ArrayList<>();
        perm2.add("G");
        perm2.add("G");
        perm2.add("R");
        perm2.add("R");
        perm2.add("R");
        List<String> perm3 = new ArrayList<>();
        perm3.add("G");
        perm3.add("R");
        perm3.add("G");
        perm3.add("R");
        perm3.add("R");
        List<String> perm4 = new ArrayList<>();
        perm4.add("G");
        perm4.add("R");
        perm4.add("R");
        perm4.add("G");
        perm4.add("R");
        List<String> perm5 = new ArrayList<>();
        perm5.add("G");
        perm5.add("R");
        perm5.add("R");
        perm5.add("R");
        perm5.add("G");
        List<String> perm6 = new ArrayList<>();
        perm6.add("R");
        perm6.add("G");
        perm6.add("G");
        perm6.add("R");
        perm6.add("R");
        List<String> perm7 = new ArrayList<>();
        perm7.add("R");
        perm7.add("G");
        perm7.add("R");
        perm7.add("G");
        perm7.add("R");
        List<String> perm8 = new ArrayList<>();
        perm8.add("R");
        perm8.add("G");
        perm8.add("R");
        perm8.add("R");
        perm8.add("G");
        List<String> perm9 = new ArrayList<>();
        perm9.add("R");
        perm9.add("R");
        perm9.add("G");
        perm9.add("G");
        perm9.add("R");
        List<String> perm10 = new ArrayList<>();
        perm10.add("R");
        perm10.add("R");
        perm10.add("G");
        perm10.add("R");
        perm10.add("G");
        test.add(perm);
        test.add(perm2);
        test.add(perm3);
        test.add(perm4);
        test.add(perm5);
        test.add(perm6);
        test.add(perm7);
        test.add(perm8);
        test.add(perm9);
        test.add(perm10);
        p1.permute(perm, 0, 4);
        Set<List<String>> test1 = new HashSet<List<String>>();
        for (List<String> l : p1.getAllPermutations()) {
            test1.add(l);
        }

        assertEquals(test, test1);
    }
    @Test
    public void test5() {

        List<Integer> perm = new ArrayList<>();
        int a=1;
        int b=2;
        int c=3;
        perm.add(a);
        perm.add(b);
        perm.add(c);
        Permutation<Integer> p1 = new Permutation(perm);
        Set<List<Integer>> test = new HashSet<List<Integer>>();
        List<Integer> perm2 = new ArrayList<>();
        perm2.add(a);
        perm2.add(c);
        perm2.add(b);
        List<Integer> perm3 = new ArrayList<>();
        perm3.add(b);
        perm3.add(c);
        perm3.add(a);
        List<Integer> perm4 = new ArrayList<>();
        perm4.add(b);
        perm4.add(a);
        perm4.add(c);
        List<Integer> perm5 = new ArrayList<>();
        perm5.add(c);
        perm5.add(a);
        perm5.add(b);
        List<Integer> perm6 = new ArrayList<>();
        perm6.add(c);
        perm6.add(b);
        perm6.add(a);
        test.add(perm);
        test.add(perm2);
        test.add(perm3);
        test.add(perm4);
        test.add(perm5);
        test.add(perm6);
        p1.permute(perm, 0, 2);
        Set<List<Integer>> test1 = new HashSet<List<Integer>>();
        for (List<Integer> l : p1.getAllPermutations()) {
            test1.add(l);
        }

        assertEquals(test, test1);
    }

    @Test
    public void test6(){
        List<Integer> perm = new ArrayList<>();
        perm.add(1); perm.add(2); perm.add(3); perm.add(4);
        Permutation<Integer> p1 = new Permutation(perm);
        p1.permuteAll();
        while(p1.hasNext()){
            System.out.println(p1.next());
        }

    }

}
