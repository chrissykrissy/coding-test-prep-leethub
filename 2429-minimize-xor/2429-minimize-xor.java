class Solution {
    public int minimizeXor(int num1, int num2) {
        int bitCount = Integer.bitCount(num2);
        bitCount -= Integer.bitCount(num1);
        int curr = 1;

        while (bitCount != 0) {
            if (bitCount < 0 && (num1 & curr) != 0) {
                num1 ^= curr; //turn off the bit
                bitCount++;
            } else if (bitCount > 0 && (num1 & curr) == 0) {
                num1 |= curr; //turn on the bit
                bitCount--;
            }
            curr <<= 1;
        }

        return num1;
        
    }
}