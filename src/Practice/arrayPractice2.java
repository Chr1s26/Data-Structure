
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class arrayPractice2{
    public static void main(String[] args) {
        
        //Printing Array
        int[] arr = new int[]{0,5,7,3,9};
        System.out.println(Arrays.toString(arr)); //O(n)

        //Copying, Cloning array
        int[] copy = Arrays.copyOf(arr, arr.length); //O(n)
        int[] copy2 = Arrays.copyOfRange(arr, 1,4); // O(n)
        System.out.println(Arrays.toString(copy2));
        System.out.println(Arrays.toString(copy));
        int[] clone = arr.clone();                  //O(n)
        System.out.println(Arrays.toString(clone));
        Arrays.fill(arr, 1);                        //O(n)
        System.out.println(Arrays.toString(arr));
        

        //Sorting array
        Arrays.sort(copy);   //nlog(n)
        System.out.println(Arrays.toString(copy));
        int index = Arrays.binarySearch(copy, 9); //log(n)
        System.out.println(index);
        
        //Sorting in descending order
        Integer[] arr2 = new Integer[]{0,5,7,3,9};
        Arrays.sort(arr2, Collections.reverseOrder());  //nlog(n)
        System.out.println(Arrays.toString(arr2));

        //Changing array to list and list to sublist
        List<Integer> list = Arrays.asList(arr2); //O(n)
        List<Integer> sublist = list.subList(1,4); //O(n)
        System.out.println(sublist);
        System.out.println(list);
    }
}