

public class substringsOfSizeThreeWithDistinctCharacters{
    public static void main(String[] args) {
        String s = "xyzzaz";
        int count = countGoodSubstrings(s);
        System.out.print(count);
    }

    public static int countGoodSubstrings(String s){

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


}

