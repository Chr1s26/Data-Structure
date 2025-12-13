import java.util.ArrayList;
import java.util.List;

public class binarySequenceRecursion {

    static int[] current;            
    static List<List<Integer>> result;  

    public static void main(String[] args) {
        List<List<Integer>> ans = generateBinarySequence(3);
        for (List<Integer> row : ans) {
            System.out.println(row);
        }
    }

    public static List<List<Integer>> generateBinarySequence(int n) {
        result = new ArrayList<>();
        current = new int[n];
        System.out.println(generate(0));  
        return result;
    }

    public static int generate(int i) {

        int count = 0;

        if (i == current.length) {
            List<Integer> copy = new ArrayList<>();
            for (int bit : current) {
                copy.add(bit);
            }
            result.add(copy);
            return count + 1;
        }

        current[i] = 0;
        count += generate(i + 1);

        current[i] = 1;
        count += generate(i + 1);


        return count;
    }
}
