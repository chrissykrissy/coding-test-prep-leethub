class Solution {
    public int minMaxDifference(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        
        // max 계산: 첫 번째로 9가 아닌 숫자 선택 → 전부 9로
        int changedMax = -1;
        char[] maxDigits = digits.clone();
        for (int i = 0; i < maxDigits.length; i++) {
            if (changedMax == -1 && maxDigits[i] != '9') {
                changedMax = maxDigits[i];
                maxDigits[i] = '9';
            } else if (maxDigits[i] == changedMax) {
                maxDigits[i] = '9';
            }
        }
        int max = Integer.parseInt(new String(maxDigits));

        // min 계산: 첫 번째로 1~9 중 하나 선택 → 전부 0으로
        int changedMin = -1;
        char[] minDigits = digits.clone();
        for (int i = 0; i < minDigits.length; i++) {
            if (changedMin == -1 && minDigits[i] != '0') {
                changedMin = minDigits[i];
                minDigits[i] = '0';
            } else if (minDigits[i] == changedMin) {
                minDigits[i] = '0';
            }
        }
        int min = Integer.parseInt(new String(minDigits));

        return max - min;
    }
}