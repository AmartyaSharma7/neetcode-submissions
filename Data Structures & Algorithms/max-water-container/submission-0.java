class Solution {
    public int maxArea(int[] heights) {
        int right = heights.length-1;
        int left = 0;
        int area = 0;
        while(left<right){
            int currArea = Math.min(heights[left],heights[right]) * (right-left);
            area = Math.max(area,currArea);
            if(heights[right] >= heights[left]){
                left++;
            }
            else{
                right--;
            }
        }
        return area;
    }
}
