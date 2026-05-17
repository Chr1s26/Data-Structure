class InfiniteMirrorStringQueries {

    public char query(long idx) {

        long len = 1;

        while (len <= idx) {
            len *= 3;
        }

        return solve(idx, len);
    }

    private char solve(long idx, long len) {

        if (len == 1) {
            return 'a';
        }

        long part = len / 3;

        if (idx < part) {

            return solve(idx, part);

        } else if (idx < 2 * part) {

            char c = solve(idx - part, part);

            return (char)((c - 'a' + 1) % 26 + 'a');

        } else {

            return solve(
                    part - 1 - (idx - 2 * part),
                    part
            );
        }
    }
}