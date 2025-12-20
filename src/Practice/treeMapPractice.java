import java.util.*;

public class treeMapPractice{
    public static void main(String[] args){
        //Sorted keys + unique keys
        TreeMap<Character,Integer> tm = new TreeMap<>();
        tm.put('A',5);  //O(log n)
        tm.put('B',4);
        tm.put('Z',2);
        tm.put('X',1);
        System.out.println(tm);
        System.out.println(tm.get('A')); //O(log n)
        //tm.remove('A'); //O(log n)
        System.out.println(tm.containsKey('A')); //O(log n)
        System.out.println(tm.containsValue(5)); //O(n)
        System.out.println(tm.size()); //tm.isEmpty(); O(1)
        System.out.println(tm.firstKey());//log n
        System.out.println(tm.lastKey());
        System.out.println(tm.firstEntry()); //log n
        System.out.println(tm.lastEntry());
        System.out.println(tm.higherKey('B')); //log n
        System.out.println(tm.lowerKey('X'));
        // System.out.println(tm.ceilingKey(1)); must be integer. O(log n)
        // System.out.println(tm.floorKey(10));
        //map.headMap(10); O(log n+k)
        //map.tailMap(10);
        //map.subMap(5,true,5,true);
    }
}