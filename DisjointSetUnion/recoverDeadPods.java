
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class recoverDeadPods{
    public static void main(String[] args) throws IOException{

        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
       
        // int n = Integer.parseInt(bufferedReader.readLine().trim());

        // int connectionsRow = Integer.parseInt(bufferedReader.readLine().trim());
        // int connectionsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        // List<List<Integer>> connections = new ArrayList<>();

        // IntStream.range(0, connectionsRow).forEach(i -> {
        //     try {
        //         connections.add(
        //             Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        //             .map(Integer::parseInt)
        //             .collect(toList())
        //         );
        //     } catch (IOException e) {
        //         throw new RuntimeException(e);
        //     }
        // });

        // int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());
        // int queriesColumns = Integer.parseInt(bufferedReader.readLine().trim());

        // List<List<Integer>> queries = new ArrayList<>();
        
        // IntStream.range(0, queriesRows).forEach(i -> {
        //     try {
        //         queries.add(
        //             Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        //             .map(Integer::parseInt)
        //             .collect(toList())
        //         );
        //     } catch (IOException e) {
        //         throw new RuntimeException(e);
        //     }
        // });

        // List<Integer> result = Result.recoverDeadPods(n,connections,queries);

        // BufferedWriter.write(
        //     result.stream()
        //     .map(Object::toString)
        //     .collect(joining("\n"))
        //     +"\n"
        // );

        // bufferedReader.close();
        // bufferedWriter.close();

        //if query 1 and node is alive, send that node. 
        //if query 1 and node is dead, find compMin (who is alive) and send to it. If no one alive = -1
        //if query 2, kill node and if node is compMin , find another compMin


        int n = 5;  

       
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2,3));
        connections.add(Arrays.asList(4,5));

        List<List<Integer>> queries = new ArrayList<>();
        
        queries.add(Arrays.asList(1,2));


        List<Integer> result =
                recoverDeadPods(n, connections, queries);

        for (int r : result) {
            System.out.println(r);
        }

    }

    public static int[] size,compMin,parent;
    public static boolean[] alive;

    public static List<Integer> recoverDeadPods(int n, List<List<Integer>> connections, List<List<Integer>> queries){
        
        parent = new int[n+1];
        size = new int[n+1];
        compMin = new int[n+1];
        alive = new boolean[n+1];

        for(int i = 1; i <= n; i++){
            parent[i] = i;
            size[i] = 1;
            compMin[i] = i;
            alive[i] = true;
        }

        for(List<Integer> c : connections){
            int a = c.get(0);
            int b = c.get(1);
            union(a,b);
        }

        for (int i = 1; i <= n; i++) {
            int root = find(i);
            if (alive[i]) {
                compMin[root] = Math.min(compMin[root], i);
            }
        }

         List<Integer> result = new ArrayList<>();

         for(List<Integer> q : queries){
            int type = q.get(0);
            int pod = q.get(1);

            if(type == 2){
                alive[pod] = false;
                int root = find(pod);
                if(compMin[root] == pod){
                    compMin[root] = findNextAlive(root,n);
                }
            }else{
                if(alive[pod]){
                    result.add(pod);
                }else{
                    int root = find(pod);
                    int receiver = compMin[root];
                    if(receiver > n) receiver = -1;
                    result.add(receiver);
                }
            }
         }

        return result;
    }

    public static int findNextAlive(int root, int n){
        int smallest = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            if(find(i) == root && alive[i]){
                smallest = Math.min(smallest, i);
            }
        }
        return smallest == Integer.MAX_VALUE ? Integer.MAX_VALUE : smallest;
    }

    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) return;

        if(size[rootA] < size[rootB]){
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
            compMin[rootB] = Math.min(compMin[rootA], compMin[rootB]);
        }else{
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
            compMin[rootA] = Math.min(compMin[rootA], compMin[rootB]);
        }
    }

    public static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

}