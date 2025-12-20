import java.util.*;

public class hashSetPractice{
    public static void main(String[] args){
        //Unique elements only
        //No order guarantee
        //Fast Lookup
        //Don't care about order
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        System.out.println(set);
        set.remove(2);
        System.out.println(set);
        System.out.println(set.contains(1));
        System.out.println(set.size());
        set.clear();
        System.out.println(set);
        
    } 

}