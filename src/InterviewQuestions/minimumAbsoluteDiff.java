import java.util.*;

public class minimumAbsoluteDiff{
    public static void main(String[] args){

    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 1; i < arr.length; i++){
            min = Math.min(min, arr[i] - arr[i-1]);
        }

        for(int j = 1; j < arr.length; j++){
            if(arr[j] - arr[j-1] == min){
                ans.add(Arrays.asList(arr[j-1],arr[j]));
            }
        }

        return ans;
    }
}