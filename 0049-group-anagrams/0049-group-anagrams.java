class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> dict = new HashMap<>();
        List<List<String>> ret = new ArrayList<>();
        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            if(!dict.containsKey(String.valueOf(arr))){
                dict.put(String.valueOf(arr), new ArrayList<>());
            }
            dict.get(String.valueOf(arr)).add(s);
        }
        ret.addAll(dict.values());
        return ret;
    }
}