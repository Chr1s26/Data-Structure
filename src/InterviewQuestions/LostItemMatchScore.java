import java.util.*;

public class LostItemMatchScore {
    public double matchScore(String[] lostTags, String[] foundTags) {
        Set<String> lostSet = new HashSet<>(Arrays.asList(lostTags));
        Set<String> foundSet = new HashSet<>(Arrays.asList(foundTags));

        Set<String> intersection = new HashSet<>(lostSet);
        intersection.retainAll(foundSet);

        Set<String> union = new HashSet<>(lostSet);
        union.addAll(foundSet);

        if (union.isEmpty()) {
            return 0.0;
        }

        return (double) intersection.size() / union.size();
    }
}