public class SearchinaSortedArrayofUnknownSize{

    static class ArrayReader{
        public int get(int index){
            int val = 0;
            return val;
        }
    }
    public int search(ArrayReader reader, int target) {

        // 1. Find search range
        int left = 0;
        int right = 1;

        while (reader.get(right) < target) {
            left = right;
            right = right * 2;
        }

       
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = reader.get(mid);

            if (val == target) {
                return mid;
            } else if (val > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

}