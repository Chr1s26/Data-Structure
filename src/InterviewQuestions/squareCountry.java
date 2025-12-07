public class squareCountry{

    public static void main(String[] args){
        System.out.print(calculateCertificate(25));
    }

    public static int calculateCertificate(int x){
        if(x==0) return 0;
        int log = (int) Math.sqrt(x);
        int diff = x - log * log;
        return calculateCertificate(diff) + 1;
    }
}

// 344 

// 18 x 18 = 324 (count +1)
// 344 - 324 = 20

// 4 x 4 = 16  (+1)
// 20 - 16 = 4

// 2 x 2 = 4 (+1)
// 4 - 4 = 0 (stop)