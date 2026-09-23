class Solution {
    public int maxProfit(int[] prices) {
        int buyTillNow = prices[0];
        int result=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]-buyTillNow > result){
                result = prices[i]-buyTillNow;
            }
            buyTillNow=Math.min(prices[i],buyTillNow);
        }
        return result;
    }
}
