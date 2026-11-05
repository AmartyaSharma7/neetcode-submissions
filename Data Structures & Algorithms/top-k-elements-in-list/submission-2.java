class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
          mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }   

        List<Integer>[] arr = new List[n+1];
        for(int i=0;i<=n;i++){
            arr[i]= new ArrayList<>();
        }
        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            arr[entry.getValue()].add(entry.getKey());
        }

        int index = 0;
        int[] ans = new int[k];
        for(int i=arr.length-1; i>0 && index<k;i--){
            for(int n1 : arr[i]){
                ans[index++] = n1;
                if(index==k)return ans;
            }
        }
        return ans;
    }
}
