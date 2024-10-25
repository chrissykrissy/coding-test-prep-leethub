class Solution {
    /*
    using binary search, we can find where pivot lies within the array
    if the mid is bigger than left, we know left part is sorted
    - check if target lies between left part vs. right part and cut the array accordingly
    */
    public int search(int[] nums, int target) {
        if(nums.length == 1 && target != nums[0]) return -1;
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }
            //check if pivot exists
            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target <= nums[mid]){
                    right = mid -1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(nums[mid] <= target && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}