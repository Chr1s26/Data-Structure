import java.util.*;

class DynamicGravityMaze {

    static class State {

        int r, c, g, flips, dist;

        State(int r, int c, int g,
              int flips, int dist) {

            this.r = r;
            this.c = c;
            this.g = g;
            this.flips = flips;
            this.dist = dist;
        }
    }

    int[] dr = {1, -1};

    public int minMoves(char[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        int sr = 0, sc = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 'S') {
                    sr = i;
                    sc = j;
                }
            }
        }

        boolean[][][][] vis =
                new boolean[n][m][2][k + 1];

        Queue<State> q = new LinkedList<>();

        State start =
                fall(grid, sr, sc, 0, 0, 0);

        q.offer(start);

        vis[start.r][start.c][0][0] = true;

        while (!q.isEmpty()) {

            State cur = q.poll();

            if (grid[cur.r][cur.c] == 'E') {
                return cur.dist;
            }

            for (int d = -1; d <= 1; d += 2) {

                int nc = cur.c + d;

                if (nc < 0 || nc >= m)
                    continue;

                if (grid[cur.r][nc] == '#')
                    continue;

                State nxt =
                        fall(grid,
                             cur.r,
                             nc,
                             cur.g,
                             cur.flips,
                             cur.dist + 1);

                if (!vis[nxt.r][nxt.c]
                        [nxt.g][nxt.flips]) {

                    vis[nxt.r][nxt.c]
                       [nxt.g][nxt.flips] = true;

                    q.offer(nxt);
                }
            }

            if (cur.flips < k) {

                int ng = 1 - cur.g;

                State nxt =
                        fall(grid,
                             cur.r,
                             cur.c,
                             ng,
                             cur.flips + 1,
                             cur.dist + 1);

                if (!vis[nxt.r][nxt.c]
                        [nxt.g][nxt.flips]) {

                    vis[nxt.r][nxt.c]
                       [nxt.g][nxt.flips] = true;

                    q.offer(nxt);
                }
            }
        }

        return -1;
    }

    private State fall(
            char[][] grid,
            int r,
            int c,
            int g,
            int flips,
            int dist
    ) {

        int n = grid.length;

        int dir = (g == 0) ? 1 : -1;

        while (true) {

            int nr = r + dir;

            if (nr < 0 || nr >= n
                    || grid[nr][c] == '#') {
                break;
            }

            r = nr;

            if (grid[r][c] == 'E') {
                break;
            }
        }

        return new State(r, c, g, flips, dist);
    }
}