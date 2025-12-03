
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class practice{
    public static void main(String[] args) {

        Integer[] arr = {6,4,7,3,4,3,1};

        testAscendingSort(arr);
        testHashMap(arr);
        testBinarySearch(arr);
        testDecendingSort(arr);
        testMultiDimensional();
        testReverseArray();
    
    }

    public static void testAscendingSort(Integer[] arr){
        Arrays.sort(arr);
        for (Integer arr1 : arr) {
            System.out.print(arr1);
        }
    }

    public static void testDecendingSort(Integer[] arr){
        Arrays.sort(arr,Collections.reverseOrder());
        System.err.println("");
        for (Integer arr1 : arr) {
            System.out.print(arr1);
        }
        System.out.println();
    }

    public static void testBinarySearch(Integer[] arr){
        System.out.println();
        int key = 4;
        int index = Arrays.binarySearch(arr, key);
        System.out.println(index);
        System.out.println(Arrays.toString(arr));
        List<Integer> list = Arrays.asList(arr);
        System.out.print(list);
    }

    public static void testMultiDimensional(){
        // int[][] multi = new int[5][5];
        int[][] multi = {{1,2,3},{2,3,1}};
        for(int i = 0; i < multi.length; i++){
            for(int j = 0; j < multi[i].length; j++){
                System.out.print(multi[i][j]);
            }
            System.out.println();
        }
    }


    public static void testReverseArray(){
        Integer[] array = {1,2,3,4,5};

        System.out.println(Arrays.toString(array));

        for(int i = 0, j = array.length-1; i < j ; i++, j--){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        System.out.println(Arrays.toString(array));

    }

    public static void testHashMap(Integer[] arr){
        System.out.println();
        Map<Integer,Integer> map = new HashMap<>();
        for(int x : arr){
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        System.out.println(map);
    }

}