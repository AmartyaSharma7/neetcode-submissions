class Solution {
    public boolean hasDuplicate(int[] nums) {
       	Set<Integer> st = new HashSet<>();
	for(int it : nums){
		if(st.contains(it))return true;
		st.add(it);
	}
return false; 
    }
}