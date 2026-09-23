class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target)return mid;
            //If Left half is sorted
            if(nums[low]<=nums[mid]){
                //If Element is in left half
                if(target >= nums[low] && target <= nums[mid]){
                    high = mid-1;
                }
                else{   //Element is in right half
                    low = mid+1;
                }
            }
            else { //If Right Half is sorted
                //If Element is in right half
                if(target >= nums[mid] && target<=nums[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
