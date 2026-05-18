import java.util.*;

class QuantumCorridorEscape {

    static class State {
        int pos, phase, dist;

        State(int p, int ph, int d) {
            pos = p;
            phase = ph;
            dist = d;
        }
    }

    public int minMoves(String s) {

        int n = s.length();

        int start = s.indexOf('S');
        int end = s.indexOf('E');

        boolean[][] vis = new boolean[n][2];

        Queue<State> q = new LinkedList<>();

        q.offer(new State(start, 0, 0));

        vis[start][0] = true;

        while (!q.isEmpty()) {

            State cur = q.poll();

            if (cur.pos == end)
                return cur.dist;

            for (int d : new int[]{-1, 1}) {

                int np = cur.pos + d;

                if (np < 0 || np >= n)
                    continue;

                char c = s.charAt(np);

                if (c == '#') {

                    if (cur.phase == 0 && np % 2 == 0)
                        continue;

                    if (cur.phase == 1 && np % 2 == 1)
                        continue;
                }

                int nextPhase = cur.phase;

                if (c == 'T')
                    nextPhase ^= 1;

                if (!vis[np][nextPhase]) {

                    vis[np][nextPhase] = true;

                    q.offer(
                        new State(
                            np,
                            nextPhase,
                            cur.dist + 1
                        )
                    );
                }
            }
        }

        return -1;
    }
}