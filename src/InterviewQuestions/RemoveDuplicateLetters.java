import java.util.*;

public class RemoveDuplicateLetters{
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        boolean[] used = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (used[c - 'a']) continue;

            while (!stack.isEmpty() 
                    && stack.peek() > c 
                    && lastIndex[stack.peek() - 'a'] > i) {

                used[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            used[c - 'a'] = true;
        }

        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}