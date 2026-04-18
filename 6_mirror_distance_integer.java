class Solution {
    public int mirrorDistance(int n) {
        int rev = 0 ;
        int original = n ;

        while (n != 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }

        int diff = Math.abs(rev - original) ;

        return diff ;
        
    }
}
