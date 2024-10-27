class Solution {
    /*
    collect all possible combination 
    → any array size n, subset is of size 2^n b/c 
        we either include or not include the values (2 choices per values)
    → TC : 2^n * n (n for copying values in the set)
    → SC : without considering the ret, O(n)
    - considering the ret array and call stack(O(n)), 2*n * n
    */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        produceAll(nums, new ArrayList<>(),0, ret);
        return ret;
    }
    public void produceAll(int[] nums, List<Integer> curr,int start, List<List<Integer>> ret){
        ret.add(new ArrayList<>(curr));
        for(int i = start; i < nums.length; i++){
            if(curr.contains(nums[i])) continue;
            curr.add(nums[i]);
            produceAll(nums, curr,i+1, ret);
            curr.remove(curr.size()-1);
        }

    }
}