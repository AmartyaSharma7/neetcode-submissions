class Solution {
    public int lengthOfLongestSubstring(String s) {
         //keep the element and its last occurance in a map
         Map<Character,Integer> mp = new HashMap<>();
         int length=0;
         int left = 0;
         for(int right=0;right<s.length();right++){
            if(mp.containsKey(s.charAt(right))){
                left = Math.max(mp.get(s.charAt(right))+1,left);
            }
            mp.put(s.charAt(right),right);
            length = Math.max(right-left+1,length);
         }
         return length;
    }
}
