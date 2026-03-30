class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int ans[] = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        } 
        int indegree[] = new int[numCourses];
        for(int it[] : prerequisites){
            adj.get(it[1]).add(it[0]);
            indegree[it[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int i = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            ans[i++] = course;
            for(int it : adj.get(course)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.offer(it);
                }
            }
        }
        
        return i == numCourses ? ans : new int[]{};
    }
}