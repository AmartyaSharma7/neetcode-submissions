class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(int i=0;i<strs.length;i++){

            int[] freq = new int[26];

            for(char it : strs[i].toCharArray()){
                freq[it-'a']++;
            }
            
            String key = Arrays.toString(freq);
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}
