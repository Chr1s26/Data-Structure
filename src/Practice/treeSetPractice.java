import java.util.*;

public class treeSetPractice{
    public static void main(String[] args){
        //Unique elements only
        //Keeps element sorted
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(10);
        ts.add(1); //O(log n)
        ts.add(100);
        System.out.println(ts);
        ts.remove(10); //O(log n)
        System.out.println(ts);
        System.out.println(ts.contains(1)); //O(log n)
        System.out.println(ts.size()); //O(log n)
        System.out.println(ts.isEmpty()); //O(1)
        System.out.println(ts.first()); //O(log n)
        System.out.println(ts.last());//O(log n)
        System.out.println(ts.higher(1)); //O(log n)
        System.out.println(ts.lower(100)); //O(log n)
        //set.ceiling(10); >= set.floor(10); <= //O(log n)


        //2   4   6   8   10   12   
        // set.headSet(8); 2   4   6 | 8   10   12
        // set.headSet(8,true); 2 4 6 8 | 10 12
        //  set.tailSet(8); 2   4   6  |8   10   12. O(log n+k)
        // set.tailSet(8,true); 2 4 6 8 | 10 12
        // set.subSet(4,10); 4 6 8 


    }
}