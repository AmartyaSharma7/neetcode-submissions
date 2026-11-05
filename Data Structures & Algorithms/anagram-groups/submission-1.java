class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>mp = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            int[] freq = new int[26];
            for(char c : strs[i].toCharArray()){
                 freq[c-'a']++;
            }
        String key = Arrays.toString(freq);
        mp.putIfAbsent(key,new ArrayList<>());
        mp.get(key).add(strs[i]);
        }
        return new ArrayList<>(mp.values());
    }
}
