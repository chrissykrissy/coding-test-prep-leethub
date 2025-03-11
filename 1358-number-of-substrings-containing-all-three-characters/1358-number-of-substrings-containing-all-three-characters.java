class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, total = 0;

        for (int right = 0; right < s.length(); right++) {
            // 현재 문자를 카운트 증가
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            // "abc"가 모두 포함될 때까지 left를 증가
            while (map.size() == 3) {
                total += s.length() - right; // 현재 right 이후의 모든 부분 문자열이 가능

                // left 문자의 개수 감소 및 필요하면 삭제
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++; // left 이동
            }
        }
        return total;
    }
}