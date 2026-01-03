import java.util.*;

public class IntersectionOfTwoArraysII{
    public static void main(String[] args){

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
        List<Integer> list = new ArrayList<>();
        

        for(int i = 0; i < nums1.length; i++){
            hm.put(nums1[i], hm.getOrDefault(nums1[i],0)+1);
        }

        for(int j = 0; j < nums2.length; j++){
            if(hm.containsKey(nums2[j]) && hm.get(nums2[j]) != 0){
                list.add(nums2[j]);
                hm.put(nums2[j], hm.get(nums2[j]) - 1);
            }
        }

        int k = 0;
        int[] ans = new int[list.size()];
        for(int li : list){
            ans[k] = li;
            k++;
        }

        return ans;
    }
}