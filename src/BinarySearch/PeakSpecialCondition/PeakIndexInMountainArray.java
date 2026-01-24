public class PeakIndexInMountainArray{
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int max = Integer.MIN_VALUE;

        while(left < right){
            int mid = left + (right - left)/2;
            if(arr[mid] > arr[mid + 1]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }
}