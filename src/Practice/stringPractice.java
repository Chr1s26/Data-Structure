
import java.util.List;

public class stringPractice{
    public static void main(String[] args){
        String s1 = "abc"; //string are immutable in java, can't modify, if modify, create new string
        s1 += "d";   // creates a NEW string
        System.out.println(s1);
        System.out.println(s1.length());

        //index string to get character
        char c1 = s1.charAt(0);
        System.out.println(c1);
        char c2 = s1.charAt(1); //O(1)
        System.out.println(c2);
        
        //String to Char array with s.toCharArray() 
        char[] c3 = s1.toCharArray();     //O(n)
        for(char c : c3) System.out.print(c);  
        System.out.println();
        //Char to String 
        String s2 = new String(c3);
        System.out.println(s2);
        //Creating a String using new String() is rare because it forces creation of a new object, 
        //bypasses the String Constant Pool, wastes memory, and provides no benefit in most cases.
        //String a = "hello"; Java stores string literals in a special memory area called the String Pool.
        //String s1 = "abc";
        //String s2 = new String("abc");
        //System.out.println(s1 == s2); // false (== compares references and Objects are different)
        //System.out.println(s1.equals(s2)); // true
        String s3 = String.valueOf(c3); //same more effective than new String(); when possible:String s = "abc";
        //string s1 = "Hello"; String s2 = "Hello";
        // Store type: s1 -> "Hello" <- s2. one object two pointer.
        //string s1 = new String(); string s2 = new String();
        // creating two different object
        //s2 = s2.intern();  

        //== checks reference, not content
        //equals() checks content
        //String a = new String("hello");
        //String b = new String("hello");
        //System.out.println(a == b); false || a.equals(b) true equals => O(n)


        //'a' = 97 
        //'A' = 65
        String s4 = "apple";
        String s5 = "canana";
        String s6 = "Apple"; 
        //"app".compareTo("apple"); all characters match, shorter come first so negative
        //compareTo() compares two strings character by character using Unicode values and returns the difference at the first mismatching position.
        System.out.println(s4.compareTo(s5)); 
        System.out.println(s5.compareTo(s4));  //O(n)
        System.out.println(s4.compareTo(s6));
        System.out.println(s4.compareToIgnoreCase(s6));

    
        String s7 = "abcdef";
        System.out.println(s7.substring(1)); //start → included O(n)
        System.out.println(s7.substring(3,5)); // end → end of string (exclusive)
        // a b c d e f
        // 0 1 2 3 4 5

        
        String s8 =  "   hello world   ";
        String[] sArr = s8.split(" "); //O(n)
        for(String s : sArr) System.out.println(s);
        System.out.println("***********");
        String s9 = "   hello world   ";
        String[] parts = s9.split(" ", -1);
        for(String s : parts) System.out.println(s);


        //["hello", "", ""] But Java removes trailing empty strings, so final result is:
        //["hello"] Those "" at the end are called trailing empty strings.
        //✔ Leading empty strings are kept
        //❌ Trailing empty strings are removed
        //trim() removes leading and trailing whitespace from a string.
        String s10 = "   hello world   ";
        System.out.println(s10.trim());

        //"abc" Matches exactly "abc"
        //"a.c" Matches: abc, a1c, a@c
        //"\\s" Matches: space,tab,new line \\s+" One or More
        //"a*" Matches: "", "a", "aaa".  //* → Zero or more
        //"a?" Matches: "", "a"
        //[abc] Matches a OR b OR c [a-z] [0-9]
        //"^hello$" Matches exactly "hello" ^ start string $end string
        //Regex is a sequence of characters that defines a search pattern for matching and manipulating strings.
        //s.matches("\\d+"); Check if string is digits only
        //s.replaceAll("\\s+", ""); Remove all spaces

        String s11 = " I  love You      java  ";
        String[] s11Arr = s11.trim().split("\\s+");
        for(String s : s11Arr) System.out.print(s); //trim => O(n)
        System.out.println("-----------------------------");
        String s12 = "a,b,c,d";
        String[] s12Arr = s12.split(",");
        //Split once (limit − 1)
        for(String s : s12Arr) System.out.println(s);
         System.out.println("-----------------------------");
        //s.matches("[a-z]+");
        //s.replaceAll("[^a-zA-Z]", ""); ^ negation so replace if number or - or sign.

        List<String> s1list = List.of("Apple", "Orange");
        String joined = String.join("-",s1list);
        System.out.println(joined);
        //String[] arr = {"2024", "09", "15"};
        //String date = String.join("/", arr);
        //String path = String.join("/", "api", "v1", "users", "10");  api/v1/users/10


        StringBuilder sb = new StringBuilder("a");
        sb.append("b"); //O(1)
        System.out.println(sb);
        sb.setCharAt(0,'z'); //O(1)
        System.out.println(sb);
        sb.reverse(); //O(n)
        System.out.println(sb);
        sb.insert(2,"t"); //O(n)
        System.out.println(sb);
        
        StringBuilder sb1 = new StringBuilder("Hello");
        sb1.delete(0,3); //O(n)
        System.out.println(sb1);
        sb1.deleteCharAt(0);  //O(n)
        System.out.println(sb1);
        System.out.println(sb1.length()); //O(1)
        //“StringBuilder is a mutable string class used to efficiently construct strings, especially in loops, avoiding the overhead of creating multiple String objects.”
    }
}
