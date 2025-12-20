
import java.util.HashMap;

public class hashMapPractice{
    public static void main(String[] args){

        //mostly O(1) but worst case O(n)
        HashMap<Character,Integer> hm1 = new HashMap<>();
        hm1.put('a',1);  //O(1)
        hm1.put('b',2);
        System.out.println(hm1);
        System.out.println(hm1.get('a')); //O(1)
        System.out.println(hm1.getOrDefault('b',0)); //O(1)
        System.out.println(hm1.containsKey('a')); //O(1)
        System.out.println(hm1.containsValue(1)); //O(n)
        hm1.remove('a'); //O(1)
        System.out.println(hm1);
        HashMap<Character,Integer> hm2 = new HashMap<>();
        hm2.put('a',1);
        hm2.put('b',2);
        hm2.put('c',3);
        for(Character c : hm2.keySet()) System.out.print(c);
        System.out.println();
        for(int i : hm2.values()) System.out.print(i);
    }
}