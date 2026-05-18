import java.util.*;

class MaximumXORSubtreeRemoval {

    List<List<Integer>> g;
    int[] val;
    int[] sub;
    int total;
    long ans = 0;

    public long maxScore(int n,
                         int[] values,
                         int[][] edges) {

        val = values;

        g = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        total = 0;

        for (int x : val)
            total ^= x;

        sub = new int[n];

        dfs(0, -1);

        return ans;
    }

    private void dfs(int u, int p) {

        sub[u] = val[u];

        for (int v : g.get(u)) {

            if (v == p)
                continue;

            dfs(v, u);

            sub[u] ^= sub[v];
        }

        if (p != -1) {

            long score =
                    (long)sub[u]
                    + (long)(total ^ sub[u]);

            ans = Math.max(ans, score);
        }
    }
}