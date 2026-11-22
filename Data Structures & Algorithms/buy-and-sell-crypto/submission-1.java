class Solution {
    public int maxProfit(int[] prices) {
        //if lesser i take it , if more i try to check if it gives more profit
        int low = prices[0];
        int ans = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<low){
                low = prices[i];
            }
            else{
                ans = Math.max(ans,prices[i]-low);
            }
        }
        return ans;
    }
}
