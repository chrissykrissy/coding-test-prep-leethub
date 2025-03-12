class Solution {
    public int maximumCount(int[] nums) {
        //lower
        int left = 0, right = nums.length-1;
        int index = nums.length;
        while (left <= right) {
            int mid = (left + right)/2;
            if (nums[mid] < 0) {
                left = mid+1;
            } else {
                right = mid-1;
                index = mid;
            }
        }

        //upper
        int index2 = nums.length;
        left = 0;
        right = nums.length-1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (nums[mid] <= 0) {
                left = mid + 1;
            } else if (nums[mid] > 0) {
                right = mid - 1;
                index2 = mid;
            }
        }
        
        int pos = nums.length - index2;
        int neg = index;
        return Math.max(pos, neg);
    }
}