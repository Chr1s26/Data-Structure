import java.util.*;

public class listPractice{
    public static void main(String[] args){

        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3));
        System.out.println(list1);
        Integer[] fixArr = new Integer[]{1,2,3};
        List<Integer> list4 = new ArrayList<>(Arrays.asList(fixArr));
        System.out.println(list4);

        //create list
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);  // O(1)
        list2.add(3);
        System.out.println(list2);
        list2.add(1,2); //O(n)
        System.out.println(list2);
        int a = list2.get(0); //O(1)
        System.out.println(a);

        //update list
        //index = 0, update number = 5, so replace 5 instead of 1
        list2.set(0,5); //O(1)
        System.out.println(list2);

        //can remove by index or by value
        List<String> list3 = new ArrayList<>(Arrays.asList("apple","orange","coconut"));
        //remove by index
        list3.remove(0); //O(n)
        System.out.println(list3);
        //remove by value
        list3.remove("orange"); //O(n)
        System.out.println(list3);

        //contains, isEmpty(), size()
        System.out.println(list3.contains("coconut")); //O(n)
        System.out.println(list3.isEmpty()); //O(1)
        System.out.println(list3.size()); // O(1)
        list3.clear(); //O(n)

        //sorting list
        List<Integer> list5 = new ArrayList<>(Arrays.asList(4,12,3,1,5));
        Collections.sort(list5);
        System.out.println(list5);
        List<String> list6 = new ArrayList<>(Arrays.asList("apple","zebra","orange","kite"));
        Collections.sort(list6);
        System.out.println(list6);
        Collections.reverse(list6);
        System.out.println(list6);
        //List<String> list = List.of("Apple", "Orange");
        //String s = String.join("-", list);  //O(n)
        //String s = "Apple,Orange";
        //List<String> list = Arrays.asList(s.split(",")); //O(n)
        //list.sort((a, b) -> a.length() - b.length());
        //list.sort((a,b) -> a.length() - b.length())
        List<String> list7 = new ArrayList<>(Arrays.asList("apple","zebra","orange","kite")); //asList O(1)
        list7.sort((d,b) -> d.length() - b.length()); //O(nlogn)
        System.out.println(list7);
        list7.sort((d,b) -> b.length() - d.length());
        System.out.println(list7);
        //binarySearch O(logn)
    }
}