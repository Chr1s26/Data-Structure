import java.util.*;

public class EncodeDecodeString{
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.size(); i++){
            sb.append(strs.get(i).length()).append('#').append(strs.get(i));
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> li = new ArrayList<>();
        int i = 0;

        //5#Hello5#World

        while(i < str.length()){
            int len = 0;

            while(str.charAt(i) != '#'){
                len = len * 10 + (str.charAt(i) - '0');
                //len = 5, i = 1
                i++;
            }

            //skip #
            i++; // i = 2

            String word = str.substring(i,i+len);
            li.add(word);

            i = i + len; // i = 7
        }

        return li;
    }
}