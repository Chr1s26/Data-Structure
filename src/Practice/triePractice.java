public class triePractice{

    static TrieNode root;

    public static void main(String[] args){
        root = new TrieNode();

        insert("cat");
        insert("car");

        System.out.println(search("cat"));     
        System.out.println(search("cap"));    
        System.out.println(startsWith("ca")); 
        System.out.println(startsWith("do")); 
    }

    public static void insert(String word){
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(cur.children[idx] == null){
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
        }
        cur.isEnd = true;
    }

    public static boolean search(String word){
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(cur.children[idx] == null){
                return false;
            }
            cur = cur.children[idx];
        }
        return cur.isEnd;
    }

    public static boolean startsWith(String prefix){
        TrieNode cur = root;
        for(char c : prefix.toCharArray()){
            int idx = c - 'a';
            if(cur.children[idx] == null){
                return false;
            }
            cur = cur.children[idx];
        }
        return true;
    }

    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }
}