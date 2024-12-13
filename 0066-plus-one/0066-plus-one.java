class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length-1; i >= 0; i--) {
            if (i == digits.length-1) {
                int num = digits[i] + 1;
                if (num >= 10) {
                    carry++;
                    digits[i] = num%10;
                } else {
                    digits[i] = num;
                }
            }else{
                if (carry > 0) {
                    int num = digits[i] + carry;
                    carry = 0;
                    if (num >= 10) {
                        carry++;
                        digits[i] = num%10;
                    } else {
                        digits[i] = num;
                    }
                }
            }
            
        }
        int[] ret = new int[digits.length+1];;
        if (carry > 0) {
            ret[0] = 1;
            for (int i = 1; i < ret.length; i++) {
                ret[i] = digits[i-1];
            }
            return ret;
        }else {
            return digits;
        }
    }
}