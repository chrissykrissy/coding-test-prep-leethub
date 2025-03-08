class Solution {
    public int minimumRecolors(String blocks, int k) {
        char[] arr = blocks.toCharArray();
        int min = Integer.MAX_VALUE;
        int whiteCount = 0;

        // 초기 윈도우 설정 (첫 k개의 'W' 개수 카운트)
        for (int i = 0; i < k; i++) {
            if (arr[i] == 'W') {
                whiteCount++;
            }
        }
        min = whiteCount;

        // 슬라이딩 윈도우
        for (int i = k; i < arr.length; i++) {
            // 이전 왼쪽 끝 문자 제거
            if (arr[i - k] == 'W') {
                whiteCount--;
            }
            // 새로운 오른쪽 문자 추가
            if (arr[i] == 'W') {
                whiteCount++;
            }
            min = Math.min(min, whiteCount);
        }

        return min;
    }
}