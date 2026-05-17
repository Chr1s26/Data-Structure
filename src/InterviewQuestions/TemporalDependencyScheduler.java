import java.util.*;

class TemporalDependencySchedular {

    static class Edge {
        int to;
        Edge(int t) {
            to = t;
        }
    }

    public int maxTasks(
            int n,
            int[] time,
            int[] deadline,
            int[][] edges,
            int k
    ) {

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for (int[] e : edges) {
            graph.get(e[0]).add(new Edge(e[1]));
            indegree[e[1]]++;
        }

        long[] start = new long[n];
        long[] finish = new long[n];

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int completed = 0;

        while (!q.isEmpty()) {

            int u = q.poll();

            finish[u] = start[u] + time[u];

            if (finish[u] <= deadline[u]) {
                completed++;
            }

            for (Edge edge : graph.get(u)) {

                int v = edge.to;

                long nextStart =
                        finish[u] + (finish[u] % k);

                start[v] =
                        Math.max(start[v], nextStart);

                indegree[v]--;

                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        return completed;
    }
}