class Solution {
    private int[] toposort(int n,List<List<Integer>> adj){
        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        List<Integer> ls = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ls.add(node);
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0)q.offer(it);
            }
        }
        return ls.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
     //Find if there is a cycle or not
     //How do u want to find - lets do toposort
    List<List<Integer>> ls = new ArrayList<>();
    for(int i=0;i<numCourses;i++){
        ls.add(new ArrayList<>());
    }
    for(int i=0;i<prerequisites.length;i++){
        ls.get(prerequisites[i][1]).add(prerequisites[i][0]);
    }
    int[] val = toposort(numCourses,ls);
    if(val.length < numCourses)return false;
    return true;
    }
}
