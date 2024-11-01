class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> {
                                    int freqCompare = freq.get(a) - freq.get(b);
                                    if (freqCompare != 0) {
                                        return freqCompare;
                                    }
                                    // 빈도가 같으면 사전순으로 정렬
                                    return b.compareTo(a);
                                });
        for(String s : words){
            freq.put(s, freq.getOrDefault(s, 0)+1);
        }
        for(String s : freq.keySet()){
            pq.add(s);
            if(pq.size() > k){
                pq.poll();
            }
        }
        String[] ret = new String[k];
        for(int i = k-1; i >= 0; i--){
            ret[i] = pq.poll();
        }
        return Arrays.asList(ret);
    }
}