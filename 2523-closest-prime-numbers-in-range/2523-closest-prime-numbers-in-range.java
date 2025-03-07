class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int p = 2; p*p <= right; p++) {
            if (isPrime[p] == true) {
                for (int i = p*p; i <= right; i+=p) {
                    isPrime[i] = false;
                }
            }
        }
        int prev = 0;
        int diff = Integer.MAX_VALUE;
        int[] ret = new int[]{-1,-1};
        for (int k = right; k >= left; k--){
            if (diff == Integer.MAX_VALUE && prev == 0 && isPrime[k]) {
                prev = k;
                continue;
            }
            if (prev != 0 && isPrime[k]){
                int temp = prev - k;
                if (temp <= diff) {
                    diff = temp;
                    ret[0] = k;
                    ret[1] = prev;
                    prev = k;
                } else {
                    prev = k;
                }
            }
        }
        return ret;
    }

}