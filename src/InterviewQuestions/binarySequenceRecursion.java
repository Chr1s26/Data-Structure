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

     public static List<List<Integer>> generateBinarySequenceV1(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        dfs(0, n, current, result);
        return result;
    }

    private static void dfs(int index, int n,
                            List<Integer> current,
                            List<List<Integer>> result) {

        // 🔹 Base case: all positions decided
        if (index == n) {
            result.add(new ArrayList<>(current)); // save COPY
            return;
        }

        // 🔹 Choice 1: put 0
        current.add(0);
        dfs(index + 1, n, current, result);
        current.remove(current.size() - 1); // backtrack

        // 🔹 Choice 2: put 1
        current.add(1);
        dfs(index + 1, n, current, result);
        current.remove(current.size() - 1); // backtrack
    }

}
