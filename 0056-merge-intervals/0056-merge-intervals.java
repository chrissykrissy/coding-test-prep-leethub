class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ret = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        for(int i = 0; i < intervals.length; i++){
            if(ret.isEmpty() || ret.getLast()[1] < intervals[i][0]){
                ret.add(intervals[i]);
            }
            if(ret.getLast()[1] >= intervals[i][0]){
                int[] temp = ret.getLast();
                ret.remove(ret.size()-1);
                ret.add(new int[] {Math.min(intervals[i][0],temp[0]), Math.max(intervals[i][1], temp[1])});
            }
        }
        return ret.toArray(new int[ret.size()][]);
    }
}