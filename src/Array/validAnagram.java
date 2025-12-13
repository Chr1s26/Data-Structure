public class validAnagram{
    public static void main(String[] args){
        String s = "anagram";
        String t = "nagaram";
        System.out.print(isValidAnagram(s, t));
    }

    public static boolean isValidAnagram(String s, String t){
        if(s.length() != t.length()) return false;
        int[] count = new int[26];

        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }

        for(char c : t.toCharArray()){
            if(count[c - 'a'] == 0) return false;
            count[c - 'a']--;
        }

        return true;
    }
}