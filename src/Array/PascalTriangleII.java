import java.util.*;

public class PascalTriangleII{
    public static void main(String[] args){

    }

    public List<Integer> getRow(int rowIndex) {
        
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < rowIndex+1; i++){
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

        return ans.get(rowIndex);
    }
}