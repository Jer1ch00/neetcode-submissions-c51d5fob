class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] e : prerequisites) {
            int u = e[0];
            int v = e[1];
            adj.get(v).add(u);
            indegree[u]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for(int i=0;i<numCourses;i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            for(int it : adj.get(node)) {
                indegree[it]--;

                if(indegree[it] == 0) {
                    q.offer(it);
                }
            }

            count++;
        }

        return count == numCourses ? true : false;

    }
}
