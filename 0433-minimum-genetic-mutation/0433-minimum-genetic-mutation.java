class Solution {
    class Holder {
        String gene;
        int num;
        public Holder(String gene, int num) {
            this.gene = gene;
            this.num = num;
        }
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> visited = new HashSet<>();
        Queue<Holder> q = new LinkedList<>();
        q.add(new Holder(startGene, 0));
        while (!q.isEmpty()) {
            Holder h = q.poll();
            if (h.gene.equals(endGene)) {
                return h.num;
            }
            visited.add(h.gene);
            for (String s : bank) {
                if (isValidMutation(h.gene, s) && !visited.contains(s)) {
                    q.add(new Holder(s, h.num+1));
                }
            }
        }

        return -1; 
    }

    public boolean isValidMutation(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1 ? true : false; 
    }
}