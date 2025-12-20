public class validAnagram{
    public static void main(String[] args){
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isValidAnagram(s, t));
        System.out.println(isValidAnagramI(s, t));
    }

    public static boolean isValidAnagramI(String s, String t){
        if(s.length() != t.length()) return false;
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++){
            char alpha = s.charAt(i);
            arr[alpha - 'a']++;
        }
        for(int j = 0; j < t.length(); j++){
            char alpha2 = t.charAt(j);
            if(arr[alpha2 - 'a'] == 0) return false;
            arr[alpha2 - 'a']--;
        }
        return true;
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