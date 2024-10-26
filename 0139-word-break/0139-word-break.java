class Solution {
    class TrieNode{
        int isEnd;
        TrieNode[] children;
        public TrieNode(){
            this.isEnd = 0;
            this.children = new TrieNode[26];
        }
    }

    class Trie{
        TrieNode root;
        public Trie(){
            this.root = new TrieNode();
        }
        public void addWord(String s){
            TrieNode head = root;
            for(char c : s.toCharArray()){
                if (head.children[c - 'a'] == null) {  // Check if the child exists
                    head.children[c - 'a'] = new TrieNode();
                }
                head = head.children[c-'a'];
            }
            head.isEnd++;
        }

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie t = new Trie();
        for(String d : wordDict){
            t.addWord(d);
        }
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i = 0; i < n; i++){
            if(!dp[i]) continue;
            TrieNode node = t.root;
            for(int j = i; j < n; j++){
                if (node.children[s.charAt(j) - 'a'] == null) {
                    break;
                }
                node = node.children[s.charAt(j) - 'a'];
                if (node.isEnd > 0) {
                    dp[j + 1] = true;  // Update dp[j+1] if a word ends at j
                }
            }
        }
        return dp[n];
    }
}