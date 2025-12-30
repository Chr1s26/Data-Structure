import java.util.*;

public class LongestSubStringWithoutRepeatingCharacter{
    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("abcbbcsed"));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int max = 0;
        int pointer = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            while(set.contains(c)){
                set.remove(s.charAt(pointer));
                pointer++;
            }
            max = Math.max(max,i - pointer + 1);
            set.add(c);
        }
        return max;
    }
}