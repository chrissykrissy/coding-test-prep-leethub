class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        int i = 0, j = 0;
        for(char c : t.toCharArray()){
            map[c]++;
        }
        int count = t.length(), minStart = 0, minLen = Integer.MAX_VALUE;
        while(j < s.length()){
            char curr = s.charAt(j);
            if(map[curr] > 0) count--;
            map[curr]--;
            j++;
            while(count == 0){
                if(minLen > j - i){
                    minLen = j-i;
                    minStart = i;
                }
                char currStart = s.charAt(i);
                map[currStart]++;
                if(map[currStart] > 0) count++;
                i++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}