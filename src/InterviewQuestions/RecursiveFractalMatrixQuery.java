class RecursiveFractalMatrixQuery {

    public long query(int k, long r, long c) {

        long ans = 0;

        for (int level = k - 1; level >= 0; level--) {

            long half = 1L << level;

            int quadrant = 0;

            if (r >= half) {
                quadrant += 2;
                r -= half;
            }

            if (c >= half) {
                quadrant += 1;
                c -= half;
            }

            ans = ans * 4 + quadrant;
        }

        return ans;
    }
}