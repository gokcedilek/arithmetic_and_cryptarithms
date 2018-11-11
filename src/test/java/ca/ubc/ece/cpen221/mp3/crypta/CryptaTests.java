package ca.ubc.ece.cpen221.mp3.expression;

import ca.ubc.ece.cpen221.mp3.cryptarithm.SolveCryptarithm;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;

public class CryptaTests {

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
    //HashMap<Character,Integer> map2= );
    //assertEquals(map,map2);
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
        //HashMap<Character,Integer> map2= );
        //assertEquals(map,map2);
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
        //HashMap<Character,Integer> map2= );
        //assertEquals(map,map2);
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
        //HashMap<Character,Integer> map3= );
        //assertEquals(map,map2);
    }
    @Test
    public void test5(){
        String[] crypta={"I" , "+" , "CANT" , "+" , "GET" , "=" , "NO" , "+" , "SATISFACTION"};
        HashMap<Character,Integer> map= new HashMap<Character, Integer>();
        //HashMap<Character,Integer> map2= );
        //assertEquals(map,map2);
    }
}