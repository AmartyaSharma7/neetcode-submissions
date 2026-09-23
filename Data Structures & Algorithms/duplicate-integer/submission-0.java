class Solution {
    public boolean hasDuplicate(int[] nums) {
        //Use a Set , If already contains - break/exit
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]))return true;
            else{
                set.add(nums[i]);
            }
        }
        return false;
    }
}