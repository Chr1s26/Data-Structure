
import java.util.ArrayList;
import java.util.List;

public class binarySequenceGenerator{
    public static void main(String[] args) {
        List<List<Integer>> binaryArr = generateBinarySequence(3);
        for(List<Integer> a : binaryArr){
            System.err.println(a);
        }
    }

    public static List<List<Integer>> generateBinarySequence(int n){
        List<List<Integer>> binaryArr = new ArrayList<>();
        
        int total = (int) Math.pow(2, n);

        for(int i = 0; i < total; i++){
            int shift = n-1;
            List<Integer> arr = new ArrayList<>();
            while(shift >= 0){
                int bit = (i >> shift) & 1;
                arr.add(bit);
                shift--;
            }
            binaryArr.add(arr);
            
        }

        return binaryArr;
    }
}