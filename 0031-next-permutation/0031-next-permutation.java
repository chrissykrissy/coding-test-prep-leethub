class Solution {
    public void nextPermutation(int[] nums) {
        int k = -1;
        for(int i = 0; i < nums.length-1;i++){
            if(nums[i] < nums[i+1]){
                k = i;
            }
        }
        if(k == -1) {
            Arrays.sort(nums);
            return;
        }

        int l = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > nums[k]){
                l = i;
            }
        }

        int temp = nums[k];
        nums[k] = nums[l];
        nums[l] = temp;
        reverse(nums, k+1, nums.length-1);
        
    }

    public void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}