
import java.util.HashMap;
import java.util.Map;

public class validAnagram{
    public static void main(String[] args){
        String s = "anagram";
        String t = "nagaram";
        System.out.print(isvalidAnagram(s,t));
    }

    public static boolean isvalidAnagram(String s, String t){
        if (s.length() != t.length()) return false;

        Map<Character,Integer> ans = new HashMap<>();
        for (char c : s.toCharArray()) {
            ans.put(c, ans.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!ans.containsKey(c)) return false;
            ans.put(c, ans.get(c) - 1);
            if (ans.get(c) == 0) ans.remove(c);
        }


        return ans.isEmpty();
    }
}