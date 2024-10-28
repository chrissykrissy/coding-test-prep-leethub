class Solution {
    /*
    TC : O(4^N * N) -> 
        4 is referring to the maximum value length in the hashmap 
        we have to explore 4 additional paths for every extra digit and for each combination, 
        costs up to N to build the combination
    SC : O(N)
    */
    static Map<String, String[]> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        //init
        map.put("2", new String[]{"a", "b", "c"});
        map.put("3", new String[]{"d", "e", "f"});
        map.put("4", new String[]{"g", "h", "i"});
        map.put("5", new String[]{"j", "k", "l"});
        map.put("6", new String[]{"m", "n", "o"});
        map.put("7", new String[]{"p", "q", "r", "s"});
        map.put("8", new String[]{"t", "u", "v"});
        map.put("9", new String[]{"w", "x", "y", "z"});

        List<String> ret = new ArrayList<>();
        if(digits.equals("")) return ret;
        String[] digit = digits.split("");
        produceAllCombs(digit,0, new StringBuilder(), ret);
        return ret;
    }

    private void produceAllCombs(String[] digit,int start, StringBuilder sb, List<String> ret){
        if(start >= digit.length || sb.length() == digit.length){
            ret.add(sb.toString());
            return;
        }
        for(int i = 0; i < map.get(digit[start]).length; i++){
            sb.append(map.get(digit[start])[i]);
            produceAllCombs(digit, start+1, sb, ret);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}