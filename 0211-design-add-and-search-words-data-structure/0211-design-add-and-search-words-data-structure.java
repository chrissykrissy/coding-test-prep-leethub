class WordDictionary {
    class TrieNode{
        boolean isWord = false;
        TrieNode[] children;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            if(curr.children[word.charAt(i)-'a'] == null){
                curr.children[word.charAt(i)-'a'] = new TrieNode();
            }
            curr = curr.children[word.charAt(i)-'a'];
        }
        curr.isWord = true; 
    }
    
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] chs, int k, TrieNode node){
        if(k == chs.length){
            return node.isWord;
        }

        if(chs[k] == '.'){
            for(int i = 0; i < node.children.length; i++){
                if(node.children[i] != null && match(chs, k+1, node.children[i])){
                    return true;
                }
            }
        }else{
            return node.children[chs[k]-'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */