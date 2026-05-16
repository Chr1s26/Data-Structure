import java.util.*;

public class CompressConsecutiveTableOrders {
    public List<String> compressTables(int[] tables) {
        List<String> result = new ArrayList<>();

        if (tables == null || tables.length == 0) {
            return result;
        }

        int start = tables[0];
        int previous = tables[0];

        for (int i = 1; i < tables.length; i++) {
            if (tables[i] == previous + 1) {
                previous = tables[i];
            } else {
                addRange(result, start, previous);
                start = tables[i];
                previous = tables[i];
            }
        }

        addRange(result, start, previous);

        return result;
    }

    private void addRange(List<String> result, int start, int end) {
        if (start == end) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "-" + end);
        }
    }
}