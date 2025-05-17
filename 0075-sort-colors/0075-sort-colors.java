class Solution {
    public void sortColors(int[] nums) {
        int p1 = 0, p2 = nums.length-1, index = 0;
        while(index <= p2){
            if(nums[index] == 0){
                //if curr is 0, swap with p1, increment p1
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if(nums[index] == 2){
                //if curr is 2, swap with p2 and decrement p2;
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                //may have swapped an extra 0 from the end of array 
                //that requires extra processing
                //so decrement index to account for it
                index--;
            }
            index++;
        }
    }
}