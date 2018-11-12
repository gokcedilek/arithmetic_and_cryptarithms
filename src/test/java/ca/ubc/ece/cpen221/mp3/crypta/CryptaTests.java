package ca.ubc.ece.cpen221.mp3.crypta;

import ca.ubc.ece.cpen221.mp3.cryptarithm.Cryptarithm;
import ca.ubc.ece.cpen221.mp3.cryptarithm.NoSolutionException;
import ca.ubc.ece.cpen221.mp3.cryptarithm.SolveCryptarithm;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.*;

public class CryptaTests {


    @Test
    public void test0(){
        String[] crypta={"ABC", "+" , "ABD" , "=" , "EDDY"};
        HashMap<Character,Integer> map= new HashMap<Character, Integer>();
        map.put('C',5);
        map.put('D',4);
        map.put('Y',9);
        map.put('A',7);
        map.put('B',2);
        map.put('E',1);
        Cryptarithm c= new Cryptarithm(crypta);
        try{
            List<Map<Character,Integer>> check= c.solve();
            System.out.println(check);

        }catch(NoSolutionException e){
            fail();
        }
    }

    @Test
    public void test1(){
        String[] crypta={"SEND", "+" , "MORE" , "=" , "MONEY"};
        HashMap<Character,Integer> map= new HashMap<Character, Integer>();
        map.put('S',9);
        map.put('E',5);
        map.put('N',6);
        map.put('D',7);
        map.put('M',1);
        map.put('O',0);
        map.put('R',8);
        map.put('Y',2);
        Cryptarithm c= new Cryptarithm(crypta);
        try{
            List<Map<Character,Integer>> check= c.solve();
            System.out.println(check);
        }catch(NoSolutionException e){
            fail();
        }
    }

    @Test
    public void test2(){
        String[] crypta={"WINTER", "+" , "IS" , "+" , "WINDIER" , "+" , "SUMMER" , "+" , "IS" , "=" , "SUNNIER"};
        HashMap<Character,Integer> map= new HashMap<Character, Integer>();
        map.put('W',7);
        map.put('I',6);
        map.put('N',0);
        map.put('T',2);
        map.put('E',8);
        map.put('R',1);
        map.put('S',9);
        map.put('D',4);
        map.put('U',3);
        map.put('M',5);
        Cryptarithm c= new Cryptarithm(crypta);
        try{
            List<Map<Character,Integer>> check= c.solve();
            System.out.println(check);

        }catch(NoSolutionException e){
            fail();
        }
    }
    @Test
    public void test3(){
        String[] crypta={"NORTH" , "/" , "SOUTH" , "=" , "EAST" , "/" , "WEST"};
        HashMap<Character,Integer> map= new HashMap<Character, Integer>();
        map.put('N',5);
        map.put('O',1);
        map.put('R',3);
        map.put('T',0);
        map.put('H',4);
        map.put('S',6);
        map.put('U',9);
        map.put('E',7);
        map.put('A',2);
        map.put('W',8);
        Cryptarithm c= new Cryptarithm(crypta);
        try{
            List<Map<Character,Integer>> check= c.solve();
            System.out.println(check);

        }catch(NoSolutionException e){
            fail();
        }
    }
    @Test
    public void test4(){
        String[] crypta={"JEDER" , "+" , "LIEBT" , "=" , "BERLIN"};
        HashMap<Character,Integer> map= new HashMap<Character, Integer>();
        HashMap<Character,Integer> map2= new HashMap<Character, Integer>();
        map.put('J',6);
        map.put('E',3);
        map.put('D',4);
        map.put('R',8);
        map.put('L',7);
        map.put('I',5);
        map.put('B',1);
        map.put('T',2);
        map.put('N',0);

        map2.put('J',4);
        map2.put('E',3);
        map2.put('D',6);
        map2.put('R',8);
        map2.put('L',9);
        map2.put('I',5);
        map2.put('B',1);
        map2.put('T',2);
        map2.put('N',0);
        Cryptarithm c= new Cryptarithm(crypta);
        try{
            List<Map<Character,Integer>> check= c.solve();
            System.out.println(check);

        }catch(NoSolutionException e){
            fail();
        }
    }
    @Test
    public void test5(){
        String[] crypta={"I" , "+" , "CANT" , "+" , "GET" , "=" , "NO" , "+" , "SATISFACTION"};
        HashMap<Character,Integer> map= new HashMap<Character, Integer>();
        Cryptarithm c= new Cryptarithm(crypta);
        try{
            List<Map<Character,Integer>> check= c.solve();
            fail();

        }catch(NoSolutionException e){

        }
    }

    @Test
    public void test6(){
        String[] crypta={"GOKCE" , "+" , "GOKSU" , "=" , "NUCLEI"};
        HashMap<Character,Integer> map= new HashMap<Character, Integer>();
        map.put('E',7);
        map.put('U',8);
        map.put('I',5);
        map.put('G',9);
        map.put('O',3);
        map.put('K',2);
        map.put('C',6);
        map.put('S',0);
        map.put('N',1);
        map.put('L',4);
        Cryptarithm c= new Cryptarithm(crypta);
        try{
            List<Map<Character,Integer>> check= c.solve();
            System.out.println(check);

        }catch(NoSolutionException e){
            fail();
        }
    }

    @Test
    public void test7(){
        String[] crypta={"ABD" , "*" , "ABC" , "=" , "COCOA"};
        HashMap<Character,Integer> map= new HashMap<Character, Integer>();
        map.put('D',3);
        map.put('C',4);
        map.put('A',2);
        map.put('B',0);
        map.put('O',1);
        Cryptarithm c= new Cryptarithm(crypta);
        try{
            List<Map<Character,Integer>> check= c.solve();
            System.out.println(check);

        }catch(NoSolutionException e){
            fail();
        }
    }

    @Test
    public void test8(){
        String[] crypta={"GOKCE" , "*" , "GOKSU" , "=" , "GOK"};
        HashMap<Character,Integer> map= new HashMap<Character, Integer>();
        Cryptarithm c= new Cryptarithm(crypta);
        try{
            List<Map<Character,Integer>> check= c.solve();
            fail();

        }catch(NoSolutionException e){

        }
    }

    @Test
    public void test9(){
        String[] crypta={"PARMIS" , "/" , "ARMIS" , "=" , "UP"};
        HashMap<Character,Integer> map= new HashMap<Character, Integer>();
        map.put('P',9);
        map.put('A',1);
        map.put('R',8);
        map.put('M',7);
        map.put('I',5);
        map.put('S',0);
        map.put('U',4);
        Cryptarithm c= new Cryptarithm(crypta);
        try{
            List<Map<Character,Integer>> check= c.solve();
            System.out.println(check);

        }catch(NoSolutionException e){
            fail();
        }
    }

    @Test
    public void mainTest() {
        String[] args = {"PARMIS" , "/" , "ARMIS" , "=" , "UP"};
        SolveCryptarithm.main(args);
    }

    @Test
    public void mainTest2() {
        String[] args = {"GOKCE" , "+" , "GOKSU" , "=" , "NUCLEI"};
        SolveCryptarithm.main(args);
    }

    @Test
    public void mainTest3() {
        String[] args = {"I" , "+" , "CANT" , "+" , "GET" , "=" , "NO" , "+" , "SATISFACTION"};
        SolveCryptarithm.main(args);
    }

    @Test
    public void test10(){
        String[] crypta={"UP" , "=" , "PARMIS" , "/" , "ARMIS" };
        HashMap<Character,Integer> map= new HashMap<Character, Integer>();
        map.put('P',9);
        map.put('A',1);
        map.put('R',8);
        map.put('M',7);
        map.put('I',5);
        map.put('S',0);
        map.put('U',4);
        Cryptarithm c= new Cryptarithm(crypta);
        try{
            List<Map<Character,Integer>> check= c.solve();
            System.out.println(check);

        }catch(NoSolutionException e){
            fail();
        }
    }

    @Test
    public void test11(){
        String[] crypta={"UP" , "=" , "PARMIS" , "=" , "ARMIS" };
        HashMap<Character,Integer> map= new HashMap<Character, Integer>();
        map.put('P',9);
        map.put('A',1);
        map.put('R',8);
        map.put('M',7);
        map.put('I',5);
        map.put('S',0);
        map.put('U',4);

        boolean thrown = false;

        try {
            Cryptarithm c= new Cryptarithm(crypta);
        } catch (IllegalArgumentException e) {
            thrown = true;

        }

        Assert.assertTrue(thrown);
    }

    @Test
    public void test12(){
        String[] crypta={"UP" , "=" , "PARMIS" , "-" , "ARMIS" };
        HashMap<Character,Integer> map= new HashMap<Character, Integer>();
        Cryptarithm c= new Cryptarithm(crypta);
        try{
            List<Map<Character,Integer>> check= c.solve();
            fail();

        }catch(NoSolutionException e){

        }
    }

    @Test
    public void test13(){
        String[] crypta={"UP" , "=" , "PARMIS" , "*" , "ARMIS" };
        HashMap<Character,Integer> map= new HashMap<Character, Integer>();
        Cryptarithm c= new Cryptarithm(crypta);
        try{
            List<Map<Character,Integer>> check= c.solve();
            fail();

        }catch(NoSolutionException e){

        }
    }

    @Test
    public void test14(){
        String[] crypta={"PARMIS" , "-" , "UP" , "=" , "ARMIS"};
        Cryptarithm c= new Cryptarithm(crypta);
        try{
            c.solve();
            fail();

        }catch(NoSolutionException e){
        }
    }


}