class Solution {
    /*
    -Find largest index k, a[k] < a[k+1]
        - if don't exist, it's the last permu (reverse the whole)
    - find largest index l greater than k, a[k] < a[l]
    - swap a[k] w/ a[l]
    - reverse a[k+1] till a[n]
    */
    public void nextPermutation(int[] nums) {
        int k = -1;
        for(int i = 0; i < nums.length-1;i++){
            if(nums[i] < nums[i+1]){
                k = i;
            }
        }
        if(k == -1) {
            reverse(nums, 0, nums.length-1);
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
            i++;
            j--;
        }
    }
}