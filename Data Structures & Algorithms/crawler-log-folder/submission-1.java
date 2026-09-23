class Solution {
    public int minOperations(String[] logs) {
        Stack<String> st = new Stack<>();
        String s1 = "./" , s2 = "../" ;
        
        for(String c : logs){
            if((c.equals(s2))){
                if(!st.isEmpty())
                    st.pop();
                continue;
            }
            else if(c.equals(s1)){
                continue;
            }
            else{
                st.push(c);
            }
        }
        return st.size();
    }
}