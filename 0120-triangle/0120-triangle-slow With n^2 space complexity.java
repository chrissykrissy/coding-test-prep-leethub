class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        for (List<Integer> l : triangle) {
            dp.add(new ArrayList<>());
            for (Integer i : l) {
                dp.get(dp.size()-1).add(Integer.MAX_VALUE);
            }
        }
        
        dp.get(0).set(0, triangle.get(0).get(0));
        for (int i = 0; i < triangle.size()-1; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                //i+1, j
                if(dp.get(i+1).get(j) != Integer.MAX_VALUE) {
                    int curr = dp.get(i).get(j) + triangle.get(i+1).get(j);
                    dp.get(i+1).set(j, Math.min(dp.get(i+1).get(j), curr));
                }else {
                    dp.get(i+1).set(j, dp.get(i).get(j) + triangle.get(i+1).get(j));
                }

                //i+1, j+1
                if(dp.get(i+1).get(j+1) != Integer.MAX_VALUE) {
                    int curr = dp.get(i).get(j) + triangle.get(i+1).get(j+1);
                    dp.get(i+1).set(j+1, Math.min(dp.get(i+1).get(j+1), curr));
                }else {
                    dp.get(i+1).set(j+1, dp.get(i).get(j) + triangle.get(i+1).get(j+1));

                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp.get(dp.size()-1).size(); i++) {
            min = Math.min(dp.get(dp.size()-1).get(i), min);
        }
        return min;
    }
}