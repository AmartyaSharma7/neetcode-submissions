class Solution {
    public int trap(int[] height) {
        int low = 0 , high = height.length-1;
        int maxLeft = height[0] , maxRight = height[high];
        int ans = 0 ;
       while(low<high){
        if(maxLeft <= maxRight){
            low++;
            maxLeft = Math.max(maxLeft,height[low]);
            ans+=maxLeft - height[low];
        }
        else{
            high--;
            maxRight = Math.max(maxRight,height[high]);
            ans += maxRight - height[high];
        }
       }
       return ans;
    }
}
