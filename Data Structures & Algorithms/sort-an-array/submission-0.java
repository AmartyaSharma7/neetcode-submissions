class Solution {
    public int[] sortArray(int[] nums) {
        Map<Integer,Integer> st = new TreeMap<>();
        for(int it : nums){
            st.put(it,st.getOrDefault(it,0)+1);
        }
        int[] ans = new int[nums.length];
        int i=0;
        for(Map.Entry<Integer,Integer> it : st.entrySet()){
            for(int j=0;j<it.getValue();j++){
                ans[i]=it.getKey();
                i++;
            }
        }
        return ans;
    }
}