class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }
        Map<Integer, Integer> cardCount = new TreeMap<>();
        for(int i = 0; i < hand.length; i++){
            cardCount.put(hand[i], cardCount.getOrDefault(hand[i], 0)+1);
        }

        while(cardCount.size() > 0){
            int curr = cardCount.entrySet().iterator().next().getKey();
            for(int i = 0; i < groupSize; i++){
                if(!cardCount.containsKey(curr+i)) return false;
                cardCount.put(curr+i, cardCount.get(curr+i)-1);
                if(cardCount.get(curr+i) == 0){
                    cardCount.remove(curr+i);
                }
            }
        }
        return true;
    }
}