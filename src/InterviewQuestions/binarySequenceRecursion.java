import java.util.ArrayList;
import java.util.List;

public class binarySequenceRecursion {

    static int[] current;            
    static List<List<Integer>> result;
    static int k = 2;

    public static void main(String[] args) {
        int input = 4;
        List<List<Integer>> ans = generateBinarySequence(input);
        for (List<Integer> row : ans) {
            System.out.println(row);
        }
    }

    public static List<List<Integer>> generateBinarySequence(int n) {
        result = new ArrayList<>();
        current = new int[n];
        System.out.println("Count is "+generate(0));  
        return result;
    }

    public static int generate(int i) {

        // int count = 0; // counting all possible combination
        int count1 = 0; // counting k 1's only

        if (i == current.length) {
            List<Integer> copy = new ArrayList<>();
            int temp = 0;
            for (int bit : current) {
                if (bit == 1) temp++;
                copy.add(bit);
            }
            result.add(copy);
            if(temp == k){
                count1++;
            }
            return count1;
            // return count + 1;
        }

        current[i] = 0;
        count1 += generate(i + 1);
        // count += generate(i + 1);

        current[i] = 1;
        count1 += generate(i + 1);
        // count += generate(i + 1);


        // return count;
        return count1;
    }
}
