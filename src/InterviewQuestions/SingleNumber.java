public class SingleNumber{
    public static void main(String[] args){
        System.out.println(findSingleNumber(new int[]{1,1,2,2}));
    }

    public static int findSingleNumber(int[] nums){
        int xor = nums[0];

        for(int i = 1; i < nums.length; i++){
            xor ^= nums[i];
        }
        return xor;
    }
}

// swapping without temp
// a = a ^ b;
// b = a ^ b;
// a = a ^ b;

// Bitwise Shift Operator
// << left shift.   3 << 1 =>   011 -> 0110   => 6   same as  3 x 2 ^ 1
// 3 << 2 =>  011 -> 01100 => 12    same as 3 x 2 ^ 2

// right shift work same 
// trick =>.  3 >> 1 => 3 / 2 = 1
// 3 >> 2 => 3 / 2 ^ 2 = 0


// -4 >> 1    // stays negative
// -4 >>> 1   // becomes positive

// (x >> k) & 1
