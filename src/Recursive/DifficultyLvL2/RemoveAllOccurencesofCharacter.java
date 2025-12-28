public class RemoveAllOccurencesofCharacter{
    public static void main(String[] args){
        System.out.println(removeChar("apple", 'p'));
    }

    public static String removeChar(String s, char ch) {
       return remove(s,ch,0);
    }

    public static String remove(String s, char ch, int index){
        if(index > s.length()-1) return s;

        if(s.charAt(index) == ch){
            s = s.substring(0,index) + s.substring(index+1,s.length());
            index--;
        }
        return remove(s,ch,index+1);
    }

    public static String removeCharV1(String s, char ch) {
        if (s.isEmpty()) return "";

        char first = s.charAt(0);
        String rest = removeChar(s.substring(1), ch);

        if (first == ch) {
            return rest;
        } else {
            return first + rest;
        }
    }

}
