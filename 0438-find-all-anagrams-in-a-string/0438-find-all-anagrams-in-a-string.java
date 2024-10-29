class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indexes = new ArrayList<>();
        HashMap<Character, Integer> freq = new HashMap<>();
        for(Character c : p.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }

        int winL = 0, winR = p.length()-1;
        while(winR < s.length()){
            if(isAnagram(s, winL, winR, freq)){
                indexes.add(winL);
            }
            winL++;
            winR++;
        }
        return indexes;

    }

    public boolean isAnagram(String s, int i, int j, HashMap<Character, Integer> map){
        int[] freq = new int[26];
        while(i <= j){
            Character c = s.charAt(i);
            freq[c-'a']++;
            i++;
        }

        for(int f = 0; f < 26; f++){
            if(freq[f]!= 0){
                if(!map.containsKey((char)(f+'a')) ||freq[f] != map.get((char)(f+'a'))){
                    return false;
                }
            }
        }
        return true;
    }
}