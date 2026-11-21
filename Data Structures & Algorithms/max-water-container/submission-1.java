class Solution {
    public int maxArea(int[] heights) {
        int l = 0 , h = heights.length-1;
        int area = 0;
        while(l<h){
            area = Math.max(Math.min(heights[l],heights[h])*(h-l),area);
            if(heights[l]<=heights[h]){
                l++;
            }
            else{
                h--;
            }
        }
        return area;
    }
}
