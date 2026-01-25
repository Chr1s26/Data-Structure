import java.util.*;

public class GroupAnagram{
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){

            String word = strs[i];

            int[] alpha = new int[26];
            for(int j = 0; j < word.length(); j++){
                char c = word.charAt(j);
                alpha[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int k = 0; k < alpha.length; k++){
                sb.append(alpha[k]).append('#');
            }

            if(map.containsKey(sb.toString())){
                map.get(sb.toString()).add(word);
            }else{
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(sb.toString(),list);
            }

        }

        for(String k : map.keySet()){
            ans.add(map.get(k));
        }

        return ans;
    }
}