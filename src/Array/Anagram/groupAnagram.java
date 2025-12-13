
import java.util.ArrayList;
import java.util.List;

public class groupAnagram{
    public static void main(String[] args) {
        String[] strs = {"act","pots","tops","cat","stop","hat"};
        List<List<String>> ans = groupAnagrams(strs);
        for(List<String> a : ans){
            System.out.println(a);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs){
        int[] ans = new int[26];
        for(char c : strs[0].toCharArray()){
            ans[c - 'a'] += 1;
        }
        for(char c : strs[1].toCharArray()){
            if(ans[c - 'a'] == 0) return new ArrayList<>();
            ans[c - 'a']--;
        }
        return new ArrayList<>();
    }
}