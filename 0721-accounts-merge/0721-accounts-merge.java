class Solution {
    class UF{
        int[] rep;
        int[] size;
        public UF(int n){
            this.rep = new int[n];
            this.size = new int[n];
            for(int i = 0; i < n; i++){
                rep[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x){
            if(x == rep[x]){
                return x;
            }
            return rep[x] = find(rep[x]);
        }

        public boolean union(int x, int y){
            int px = find(x);
            int py = find(y);
            if(px == py) return false;
            if(size[px] < size[py]){
                size[py] += size[px];
                rep[px] = py;
            }else{
                size[px] += size[py];
                rep[py] = px;
            }
            return true;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UF uf = new UF(accounts.size());
        HashMap<String, Integer> mailToId = new HashMap<>();
        HashMap<Integer, String> IdToName = new HashMap<>();
        for(int i = 0; i < accounts.size(); i++){
            List<String> account = accounts.get(i);
            String name = account.get(0);
            IdToName.put(i, name);
            for(int j = 1; j < account.size(); j++){
                if(mailToId.containsKey(account.get(j))){
                    uf.union(i, mailToId.get(account.get(j)));
                }
                mailToId.put(account.get(j), i);
            }
        }

        Map<Integer, List<String>> components = new HashMap<>();
        for(String email : mailToId.keySet()){
            int group = mailToId.get(email);
            int groupRep = uf.find(group);

            if(!components.containsKey(groupRep)){
                components.put(groupRep, new ArrayList<String>());
            }
            components.get(groupRep).add(email);
        }

        List<List<String>> list = new ArrayList<>();
        for(int group : components.keySet()){
            List<String> component = components.get(group);
            Collections.sort(component);
            component.add(0, accounts.get(group).get(0));
            list.add(component);
        }

        return list;
    }
}