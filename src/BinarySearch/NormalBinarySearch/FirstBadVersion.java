public class FirstBadVersion{
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while(left < right){
            int mid = left + (right - left)/2;
            boolean isBad = isBadVersion(mid);

            if(isBad){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return right;
    }

    public boolean isBadVersion(int mid){
        return true;
    }
}