class Solution {
    char[] arr;
    public int countPalindromicSubsequence(String s) {
        arr = s.toCharArray();
        int lastIndex = -1;
        int firstIndex = -1;
        int total = 0;
        for (int i = 0; i < 26; i++) {
            for (int c = 0; c < arr.length; c++) {
                if (firstIndex == -1 && arr[c] == 'a' + i) {
                    firstIndex = c;
                }else if (arr[c] == 'a' + i) {
                    lastIndex = c;
                }
            }
            total += countUnique(firstIndex, lastIndex);
            firstIndex = -1;
            lastIndex = -1;
        }
    //     for (int i = arr.length-1; i > 1; i--) {
    //         if (arr[i] == arr[firstIndex]) {
    //             lastIndex = i;
    //             total += countUnique(firstIndex, lastIndex); 
    //         }
    //     }
        return total;
    }

    public int countUnique(int i, int j) {
        int count = 0;
        int[] alph = new int[26];
        for (int start = i+1; start < j; start++) {
            if (alph[arr[start]-'a'] == 0) {
                count++;
                alph[arr[start]-'a']++;
            }
        }
        return count;
    }
}