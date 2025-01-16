class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int num1 = 0;
        int num2 = 0;
        
        if (n % 2 != 0) {
            for (int i = 0; i < nums2.length; i++) {
                num1 ^= nums2[i];
            }
        }
        
        if (m % 2 != 0) {
            for (int i = 0; i < nums1.length; i++) {
                num2 ^= nums1[i];
            }
        }
        return num1 ^ num2;
    }
}