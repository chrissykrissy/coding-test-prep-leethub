class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        for(int i = 0; i < intervals.length; i++){
            if(result.isEmpty() || result.getLast()[1] < intervals[i][0]){
                result.add(intervals[i]);
            }else{
                result.getLast()[1] = Math.max(result.getLast()[1], intervals[i][1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}