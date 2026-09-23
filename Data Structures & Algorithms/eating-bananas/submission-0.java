class Solution {
    public boolean isComplete(int mid,int[] piles,int h){
        int sum = 0;
        for(int i=0;i<piles.length;i++){
            sum += (int)(Math.ceil((double)piles[i]/(double)mid));
        }
        return sum<=h ? true : false;
    }
    public int minEatingSpeed(int[] piles, int h) {
        //minimum rate to eat bananas
        //maximum - highest in the array
        //lowest is 1
        int low =1 , high = 0;
        for(int i=0;i<piles.length;i++){
            high = Math.max(high,piles[i]);
        }
        int ans = 0;
        while(low<=high){
            int mid = (low+high)/2;
            if(isComplete(mid,piles,h)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}
