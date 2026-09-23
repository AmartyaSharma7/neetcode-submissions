class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        int n1 = s.length();
        int n2 = t.length();

        //exit early
        if(n1!=n2)return false;

        for(int i=0;i<n1;i++){
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }

       for(int val : freq){
        if(val!=0)return false;
       }
       return true;
    }
}
