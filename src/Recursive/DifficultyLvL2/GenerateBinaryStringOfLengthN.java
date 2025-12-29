import java.util.*;

public class GenerateBinaryStringOfLengthN{

    public static List<Integer> list = new ArrayList<>();
    public static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args){
        generateBinaryStrings(0);
        for(List<Integer> li : ans){
            System.out.println(li.toString());
        }
    }

    public static void generateBinaryStrings(int n) {
        generate(0);
    }

    public static void generate(int n){
        if(n == 3){
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(0);
        generate(n+1);
        list.remove(n);

        list.add(1);
        generate(n+1);
        list.remove(n);
    }

}