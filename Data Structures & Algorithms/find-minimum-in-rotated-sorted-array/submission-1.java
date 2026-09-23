class Solution {
    public int findMin(int[] nums) {
        int low = 0 , high = nums.length-1;
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            //If Left side is Sorted
            if(nums[low] <= nums[mid]){
                //Answer might be in left half
                ans = Math.min(ans,nums[low]);
                //Or IN Right half
                low= mid+1;
            }
            else{
                //Answer Might be in Right Half
                ans = Math.min(ans,nums[mid]);
                //Or in left Half
                high = mid-1;
            }
        }
        return ans;
    }
}
