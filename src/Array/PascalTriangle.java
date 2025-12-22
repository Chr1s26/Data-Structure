
import java.util.*;

public class PascalTriangle{
    public static void main(String[] args){
        List<List<Integer>> ans = generate(5);
        for(List<Integer> l : ans){
            for(int c : l){
                System.out.print(c);
            }
        }
    }
    
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(Arrays.asList(1)));
        if(numRows == 1) return ans;
        ans.add(new ArrayList<>(Arrays.asList(1,1)));
        if(numRows == 2) return ans;
        

        for(int i = 2; i < numRows; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            List<Integer> before = ans.get(i-1);
            for(int j = 1; j < before.size(); j++){
                temp.add(before.get(j)+before.get(j-1));
            }
            temp.add(1);
            ans.add(temp);
        }

        return ans;
    }

    public static List<List<Integer>> generateV1(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            List<Integer> li = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    li.add(1);
                }else{
                    List<Integer> temp = ans.get(i-1);
                    li.add(temp.get(j)+temp.get(j-1));
                }
            }
            ans.add(li);
        }

        return ans;
    }
}