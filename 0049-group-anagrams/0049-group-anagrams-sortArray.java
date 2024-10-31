class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s : strs){
            String sorted = sortString(s);
            if(map.containsKey(sorted)){
                map.get(sorted).add(s);
            }else{
                map.put(sorted, new ArrayList<>(Arrays.asList(s)));
            }
        }

        for(String s: map.keySet()){
            ret.add(map.get(s));
        }

        return ret;
        
    }

    private String sortString(String s){
        char[] cArray = s.toCharArray();
        Arrays.sort(cArray);
        return new String(cArray);
    }
}