
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupAnagram{
    public static void main(String[] args) {
        String[] strs = {"act","xyz","pots","tops","cat","stop","hat"};
        List<List<String>> ans1 = groupAnagrams(strs);
        for(List<String> a : ans1){
            System.out.println(a);
        }
        List<List<String>> ans2 = groupAnagramsV2(strs);
        for(List<String> a : ans2){
            System.out.println(a);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> ans = new ArrayList<>();
 
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder();
            for (char c : arr) {
                sb.append(c); 
            }
            if (map.containsKey(sb.toString())) {
                List<String> temp1 = map.get(sb.toString());
                temp1.add(str);
                map.put(sb.toString(), temp1);
            } else {
                List<String> temp2 = new ArrayList<>();
                temp2.add(str);
                map.put(sb.toString(),temp2);
                ans.add(map.get(sb.toString()));  
            }
        }
        return ans;
    }

    public static List<List<String>> groupAnagramsV2(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for (int num : count) {
                key.append(num).append('#');   
            }

            map.computeIfAbsent(key.toString(), x -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}