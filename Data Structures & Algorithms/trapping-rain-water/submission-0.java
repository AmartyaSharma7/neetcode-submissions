class Solution {
    public int trap(int[] height) {
        int maxLeft = height[0];
        int maxRight = height[height.length-1];
        int left = 0 , right = height.length-1;
        int ans = 0;
        while(left < right){
            if(maxLeft <= maxRight){
                //move the left pointer
                left++;
                maxLeft = Math.max(maxLeft,height[left]);
                ans += maxLeft - height[left];
            }
            else{
                right--;
                maxRight = Math.max(maxRight,height[right]);
                ans += maxRight - height[right];
            }
        }
        return ans;
    }
}
