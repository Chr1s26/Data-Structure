
import java.util.*;

public class substringsOfSizeThreeWithDistinctCharacters{
    public static void main(String[] args) {
        
        String s = "owuxoelszb"; 
        int count1 = countGoodSubStringsV1(s);
        System.out.println(count1);
        int count2 = countGoodSubStringsV2(s);
        System.out.println(count2);
        //if length is not fixed
        int count3 = countGoodSubStringV3(s,3);
        System.out.print(count3);
    }

    public static int countGoodSubStringsV1(String s){

        int count = 0;
    
        for(int i = 0; i < s.length()-2; i++){
            char a = s.charAt(i);
            char b = s.charAt(i+1);
            char c = s.charAt(i+2);

            if(a != b && b != c && c != a){
                count++;
            }
        }
        return count;
    }
    
        public static int countGoodSubStringsV2(String s){
        int count = 0;
        int size = s.length();
        if(size < 3) return 0;

        HashSet<Character> hs = new HashSet<>();
        int cur = 0;
        int i = 0;
        int countLoop = 0;
        while(i != size){
            hs.add(s.charAt(i));
            countLoop++;
            i++;
            if(countLoop == 3){
                if(hs.size() == 3) count++;
                hs.clear();
                countLoop = 0;
                cur++;
                i = cur;
            }
        }
        return count;
    }

    public static int countGoodSubStringV3(String s,int k ){

        int count = 0;
        int len = s.length();

        if(len < k) return count;
        
        HashSet<Character> hs = new HashSet<>();
        int left = 0;
        
        for(int right = 0; right < len; right++){
            while(hs.contains(s.charAt(right))){
                hs.remove(s.charAt(right));
                left++;
            }

            hs.add(s.charAt(right));
            if(right - left + 1 == k){
                count++;
                hs.remove(s.charAt(left));
                left++;
            }
        }
        return count;
    }

}

