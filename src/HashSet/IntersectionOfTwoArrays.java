import java.util.*;

public class IntersectionOfTwoArrays{
    public static void main(String[] args){

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();

        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }
        for(int j = 0; j < nums2.length; j++){
            if(set.contains(nums2[j])){
                intersect.add(nums2[j]);
            }
        }

        int[] ans = new int[intersect.size()];
        int k = 0;

        for(int s : intersect){
            ans[k] = s;
            k++;
        }

        return ans;
    }
}