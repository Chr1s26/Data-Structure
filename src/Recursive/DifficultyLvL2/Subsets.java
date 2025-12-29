import java.util.*;
public class Subsets{
    public static void main(String[] args){
        subsets(new int[]{1,2,3});
        for(List<Integer> li : ans){
            System.out.println(li.toString());
        }
    }

    public static List<List<Integer>> ans = new ArrayList<>();
    public static List<Integer> list = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        generate(nums,0,0,0);
        return ans;
    }

    public static void generate(int[] nums,int index,int left,int right){

        list.add(nums[left]);
        ans.add(new ArrayList<>(list));

        if(left >= nums.length-1){
            list.remove(index);
            return;
        }
        
        generate(nums,++index,++left,right);

        
        index--;
        list.remove(index);
        left--;

        if(list.isEmpty()){
            right++;
            left = right - 1;
        }
        generate(nums,index,++left,right);

    }

    // dfs(nums, 0, new ArrayList<>(), ans);
    private void dfs(int[] nums, int index, List<Integer> current, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        dfs(nums, index + 1, current, ans);

        current.add(nums[index]);
        dfs(nums, index + 1, current, ans);
        current.remove(current.size() - 1);
    }
}

//1,2
//[]
//[2]
//[]
//[1]
//[1,2]


//index = 0 dfs => index 1
//index = 1 dfs => index 2 => return

//index = 1, dfs => index 2 => return

//index = 0, dfs => index 1 


