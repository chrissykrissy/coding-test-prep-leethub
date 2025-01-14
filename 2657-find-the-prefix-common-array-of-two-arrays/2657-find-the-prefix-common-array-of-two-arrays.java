class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ret = new int[n];
        int[] freq = new int[n+1];

        for (int i = 0; i < n; i++) {
            freq[A[i]]++;
            freq[B[i]]++;
            ret[i] = retCount(freq);
        }
        return ret;
    }

    public int retCount(int[] freq) {
        int count = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 2) {
                count++;
            }
        }
        return count;
    }
}