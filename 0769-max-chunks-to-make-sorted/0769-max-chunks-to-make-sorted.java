class Solution {
    public int maxChunksToSorted(int[] arr) {
        int num = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            if (max == i) {
                num++;
            }
        }
        return num;

        //0,1,2,3,4,5,6,7,8
        //1,4,4,6,6,7,8,8,8
    }
}