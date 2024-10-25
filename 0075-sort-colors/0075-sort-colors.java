class Solution {
    public void sortColors(int[] nums) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for(int i : nums){
            if(i == 0){
                cnt0++;
            }else if(i == 1){
                cnt1++;
            }else{
                cnt2++;
            }
        }
        int itr = 0;
        for(int i = 0; i < cnt0; i++){
            nums[itr] = 0;
            itr++;
        }
        for(int i = 0; i < cnt1; i++){
            nums[itr] = 1;
            itr++;
        }
        for(int i = 0; i < cnt2; i++){
            nums[itr] = 2;
            itr++;
        }
    }
}