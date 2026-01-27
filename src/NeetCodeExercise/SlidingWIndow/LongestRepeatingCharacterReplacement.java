public class LongestRepeatingCharacterReplacement{
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int right = 0;
        int maxFrequency = 0;
        int max = 0;

        while(right < s.length()){
            char c = s.charAt(right);

            count[c - 'A']++;
            maxFrequency = Math.max(maxFrequency,count[c - 'A']);
            int distance = right - left + 1;
            int need = distance - maxFrequency;
            
            if(need > k){
                count[s.charAt(left) - 'A']--;
                left++;
            }

            max = Math.max(max,right - left + 1);
            right++;
        }
        return max;
    }
}