import java.util.*;

public class StringWithConcatenationOfAllWords{
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) return result;

        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;

        // Frequency map of words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words) {
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }

        // Try each offset
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            int count = 0;
            Map<String, Integer> windowMap = new HashMap<>();

            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (!wordCount.containsKey(word)) {
                    windowMap.clear();
                    count = 0;
                    left = right;
                } else {
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    count++;

                    // Shrink if word appears too many times
                    while (windowMap.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    if (count == words.length) {
                        result.add(left);
                    }
                }
            }
        }
        return result;
    }
}