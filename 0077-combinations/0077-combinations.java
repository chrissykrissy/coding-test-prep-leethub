class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>(); 
        int[] num = new int[n];
        for (int i = 1; i <= n; i++) {
            num[i-1] = i;
        }
        allComb(num, k, 0, new ArrayList<>(), ret);
        return ret;
    }

    public void allComb(int[] num, int k, int index, List<Integer> curr, List<List<Integer>> ret) {
        if (curr.size() == k) {
            ret.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index; i < num.length; i++) {
            curr.add(num[i]);
            allComb(num, k, i+1, curr, ret);
            curr.remove(curr.size()-1);
        }
    }

}