public class ReverseArray{
    public static void main(String[] args){
        int[] arr = reverse(new int[]{1, 2, 3, 4, 5});
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
    }

    public static int[] reverse(int[] arr) {
       reverseHelper(arr,0,arr.length-1);
       return arr;
    }

    public static void reverseHelper(int[] arr, int left, int right) {
        if(left > right) return;
        int temp = arr[right];
        arr[right] = arr[left];
        arr[left]  = temp;
        reverseHelper(arr,++left,--right);
    }

}