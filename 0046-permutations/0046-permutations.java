class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        compute(nums, new ArrayList<Integer>(), ret);
        return ret;
    }

    public void compute(int[]nums, List<Integer> curr, List<List<Integer>> ret){
        if(curr.size() == nums.length){
            ret.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!curr.contains(nums[i])){
                curr.add(nums[i]);
                compute(nums, curr, ret);
                curr.remove(curr.size()-1);
            }
        }
    }
}