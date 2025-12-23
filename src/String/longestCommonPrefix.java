public class longestCommonPrefix{
    public static void main(String[] args){
        
    }

    public static String findLongestCommonPrefix(String[] strs){
        if(strs == null || strs.length == 0) return "";

        for(int i = 0; i < strs[0].length(); i++){
            String ans = strs[0];
            for(int j = 1; j < strs.length; j++){
                if(i >= strs[j].length() || ans.charAt(i) != strs[j].charAt(i)){
                    return ans.substring(0,i);
                }
            }
        }

        return strs[0];
    }
}