class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int i : nums){
        st.add(i);
        }
        int maxLen = 0;
        for(int it : st){
            if(!st.contains(it-1)){
                int n = 1;
                while(st.contains(it+n)){
                        n++;
                }
                maxLen = Math.max(n,maxLen);
            }
        }
        return maxLen;
    }
}
