public class WildCardMatching{
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        int starIndex = -1;
        int matchIndex = 0;

        while (i < s.length()) {

            // Case 1: match or '?'
            if (j < p.length() &&
                (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            }

            // Case 2: '*'
            else if (j < p.length() && p.charAt(j) == '*') {
                starIndex = j;
                matchIndex = i;
                j++;
            }

            // Case 3: mismatch but previous '*'
            else if (starIndex != -1) {
                j = starIndex + 1;
                matchIndex++;
                i = matchIndex;
            }

            // Case 4: mismatch and no '*'
            else {
                return false;
            }
        }

        // Remaining pattern should be all '*'
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();
    }
}