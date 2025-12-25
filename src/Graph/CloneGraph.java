import java.util.*;

public class CloneGraph{
    public static void main(String[] args){

    }

    public static HashMap<Node,Node> hm = new HashMap<>();

    public static Node cloneGraph(Node node){
        if(node == null) return null;

        if(hm.containsKey(node)){
            return hm.get(node);
        }

        Node clone = new Node(node.val);
        hm.put(node,clone);

        for(Node nei : node.neighbors){
            clone.neighbors.add(cloneGraph(nei));
        }
        return clone;
    }

    static class Node{
        int val;
        List<Node> neighbors;

        public Node(int val){
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }
}