class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i][0], nums1[i][1]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i][0])) {
                map.put(nums2[i][0], map.get(nums2[i][0]) + nums2[i][1]);
            }else {
                map.put(nums2[i][0], nums2[i][1]);
            }
        }

        List<Integer> keys = new ArrayList(map.keySet());
        Collections.sort(keys);
        int[][] ret = new int[keys.size()][2];
        for (int i = 0; i < keys.size(); i++) {
            ret[i][0] = keys.get(i);
            ret[i][1] = map.get(ret[i][0]);
        }
        return ret;
    }
}