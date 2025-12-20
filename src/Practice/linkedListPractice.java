import java.util.*;

public class linkedListPractice{
    public static void main(String[] args){
        //A LinkedList is a linear data structure made of nodes.
        //Each node contains: [value | pointer(s)]
        //In Java, LinkedList is a doubly linked list: null ← A ↔ B ↔ C → null
        // cannot use get(index) cause traverse node by node

        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(10); //O(1)
        ll.add(11);
        ll.addLast(15); //O(1)
        System.out.println(ll);

        System.out.println("Add 100 at first place");
        ll.addFirst(100); //O(1)
        System.out.println(ll);

        System.out.println("Add 4 at the index of 1");
        ll.add(1,4); //index = 1, value = 4 O(n)
        System.out.println(ll);

        System.out.println("Remove First Element");
        ll.removeFirst(); //O(1)
        System.out.println(ll);

        System.out.println("Remove Last Element");
        ll.removeLast(); //O(1)
        System.out.println(ll);

        System.out.println("Get First Element");
        System.out.println(ll.getFirst());  //O(1)
        System.out.println("Get Last Element");
        System.out.println(ll.getLast()); //O(1)

        System.out.println("Check with Contains");
        System.out.println(ll.contains(11)); //O(n)

        System.out.println("Get index with value");
        System.out.println(ll.indexOf(4)); //O(n)
    }
}