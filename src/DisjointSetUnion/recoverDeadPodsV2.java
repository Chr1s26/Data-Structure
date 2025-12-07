
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class recoverDeadPodsV2{
    public static void main(String[] args) {
        int n = 5;  
       
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 3));
        connections.add(Arrays.asList(4, 5));

        List<List<Integer>> queries = new ArrayList<>();
        queries.add(Arrays.asList(1, 1)); // send to 1
        queries.add(Arrays.asList(2, 2)); // kill 2
        queries.add(Arrays.asList(1, 2)); // send to 2
        queries.add(Arrays.asList(2, 1)); // kill 1
        queries.add(Arrays.asList(1, 3)); // send to 3
        queries.add(Arrays.asList(2, 3)); // kill 3
        queries.add(Arrays.asList(1, 1)); // send to 1

        List<Integer> result =
                recoverDeadPods(n, connections, queries);

        for (int r : result) {
            System.out.println(r);
        }
    }

    static int[] parent, size;
    static TreeSet<Integer>[] aliveSet;

    public static List<Integer> recoverDeadPods(int n, List<List<Integer>> connections,
                                                List<List<Integer>> queries) {

        parent = new int[n + 1];
        size = new int[n + 1];
        aliveSet = new TreeSet[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
            aliveSet[i] = new TreeSet<>();
            aliveSet[i].add(i);    
        }

       
        for (List<Integer> c : connections) {
            union(c.get(0), c.get(1));
        }

        List<Integer> result = new ArrayList<>();

        for (List<Integer> q : queries) {
            int type = q.get(0);
            int pod = q.get(1);

            if (type == 2) {

                int root = find(pod);
                aliveSet[root].remove(pod);

            } else {
                int root = find(pod);
                if (aliveSet[root].isEmpty()) result.add(-1);
                else result.add(aliveSet[root].first());
            }
        }

        return result;
    }

    static int find(int x) {
        if (x != parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);

        if (ra == rb) return;

      
        if (size[ra] < size[rb]) {
            parent[ra] = rb;
            size[rb] += size[ra];
  
            aliveSet[rb].addAll(aliveSet[ra]);
        } else {
            parent[rb] = ra;
            size[ra] += size[rb];
            aliveSet[ra].addAll(aliveSet[rb]);
        }
    }

}