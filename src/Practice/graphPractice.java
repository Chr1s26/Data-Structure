import java.util.*;

public class graphPractice{
    public static void main(String[] args){
        int n = 5;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(1).add(0);
        
    }

    public static void dfs(int node, boolean[] visited, List<List<Integer>> graph){
        visited[node] = true;
        for(int nei : graph.get(node)){
            if(!visited[nei]){
                dfs(nei,visited,graph);
            }
        }
    }

    public static void bfs(int node, boolean[] visited, List<List<Integer>> graph){
        visited[node] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(node);
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int nei : graph.get(temp)){
                if(!visited[nei]){
                    visited[nei] = true;
                    q.offer(nei);
                }
            }
        }
    }

    public static int countComponents(int n, List<List<Integer>> graph){
        boolean[] visited = new boolean[graph.size()];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i,visited,graph);
                count++;
            }
        }
        return count;
    }

    //Directed Graph
    public static boolean hasCycle(int node,int parent,boolean[] visited,List<List<Integer>> graph){
        visited[node] = true;
        for(int nei : graph.get(node)){
            if(!visited[nei]){
                if(hasCycle(nei,node,visited,graph)){
                    return true;
                }
            }else if(nei != parent){
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycle(int node, boolean[] visited, boolean[] inStack,List<List<Integer>> graph) {
        visited[node] = true;
        inStack[node] = true;

        for(int nei : graph.get(node)){
            if(!visited[nei]){
                if(hasCycle(nei,visited,inStack,graph)){
                    return true;
                }
            }else if(inStack[nei]){
                return true;
            }
        }
        inStack[node] = false; //important
        return false;
    }

    public static int[] topoSort(int n, List<List<Integer>> graph) {

        int[] inDegree = new int[n];

        for(int i = 0; i < n; i++){
            for(int nei : graph.get(i)){
                inDegree[nei]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        int[] order = new int[n];
        int idx = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            order[idx++] = node;

            for(int nei : graph.get(node)){
                if(--inDegree[nei] == 0){
                    q.offer(nei);
                }
            } 
        }
        return order;
    }
}

// 0 → 1
// 0 → 2
// Node 0:
// indegree = 0
// outdegree = 2