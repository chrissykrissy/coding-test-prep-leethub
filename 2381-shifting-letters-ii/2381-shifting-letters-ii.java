class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] prefix = new int[s.length() + 1];

        for (int[] sh : shifts) {
            int start = sh[0];
            int end = sh[1];
            int dir = sh[2];
            if (dir == 1) {
                prefix[start] += 1;
                prefix[end + 1] -= 1;
            } else {
                prefix[start] -= 1;
                prefix[end + 1] += 1;
            }
        }
        
        // Prefix 누적합 계산
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] += prefix[i - 1];
        }

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int shift = prefix[i] % 26; // 알파벳은 26개
            if (shift < 0) shift += 26; // 음수 처리
            
            arr[i] = (char) ((arr[i] - 'a' + shift) % 26 + 'a');
        }
        return new String(arr);
    }
}