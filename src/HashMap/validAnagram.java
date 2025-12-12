
import java.util.HashMap;
import java.util.Map;

public class validAnagram{
    public static void main(String[] args){
        String s = "anagram";
        String t = "nagaram";
        System.out.print(isvalidAnagram(s,t));
    }

    public static boolean isvalidAnagram(String s, String t){
        Map<Character,Integer> ans = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(ans.containsKey(s.charAt(i))){
                ans.put(s.charAt(i), ans.get(s.charAt(i))+1);
            }else{
                ans.put(s.charAt(i),1);
            }
        }

        for(int j = 0; j < t.length(); j++){
            if(ans.containsKey(t.charAt(j))){
                if(ans.get(t.charAt(j)) == 1) ans.remove(t.charAt(j));
                else ans.put(t.charAt(j),ans.get(t.charAt(j))-1);
            }else{
                return false;
            }
        }

        return true;
    }
}