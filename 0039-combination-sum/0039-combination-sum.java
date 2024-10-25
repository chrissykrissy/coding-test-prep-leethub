class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), ret);
        return ret;
    }

    public void backtrack(int[] cand, int target, int start, List<Integer> curr, List<List<Integer>> ret){
        if(target < 0) return;

        if(target == 0){
            ret.add(new ArrayList<>(curr));
        }

        for(int i = start; i < cand.length; i++){
            curr.add(cand[i]);
            backtrack(cand, target-cand[i], i, curr, ret);
            curr.remove(curr.size()-1);
        }
    }
}