class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        while (h < citations.length && citations[citations.length - 1 - h] > h) {
            h++;
        }
        return h;
    }
}