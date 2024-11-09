class Solution {
    /*
    3 ways to solve
    1. nlogn, O(1) sort and return mid value
    2. n, O(n), use hash table to keep freq
    3. n, O(1) BMV algo
    
    Boyer-Moore Voting Algo
    - assumption : occurance greater than n/2
    
    */
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for(int num : nums){
            if(count == 0){
                candidate = num;
            }
            count += num == candidate ? 1 : -1;
        }
        return candidate;
    }
}