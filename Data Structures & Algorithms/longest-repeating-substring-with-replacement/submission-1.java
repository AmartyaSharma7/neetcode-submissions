class Solution {
    public int helperFunc(int[] freq){
        int ans=0;
        for(int i=0;i<26;i++){
            ans = Math.max(freq[i],ans);
        }
        return ans;
    }
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l=0,r=0;
        int ans = 0;
        while(r<s.length()){
            freq[s.charAt(r)-'A']++;
            int mostFrequent = helperFunc(freq);
            if(r-l+1 - mostFrequent <= k){
                ans = Math.max(ans,r-l+1);
            }
            else{
                freq[s.charAt(l)-'A']--;
                l++;
            }
            r++;
        }
        return ans;
    }
}
