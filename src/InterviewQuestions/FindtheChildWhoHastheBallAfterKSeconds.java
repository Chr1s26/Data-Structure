public class FindtheChildWhoHastheBallAfterKSeconds{
    public static void main(String[] args){

    }

    public static int numberOfChild(int n, int k) {
        int cycle = 2 * (n - 1);
        int pos = k % cycle;

        if(pos < n){
            return pos;
        }else{
            return cycle - pos;
        }
    }
}