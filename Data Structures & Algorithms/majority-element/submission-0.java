class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i] , mp.getOrDefault(nums[i],0)+1);
        }
        int len = nums.length/2;
        for(Map.Entry<Integer,Integer> it : mp.entrySet()){
            if(it.getValue()>len){
                return it.getKey();
            }
        }
        return 0;
    }
}