class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for(int pre[] : prerequisites) {
            int u = pre[0];
            int v = pre[1];

            adj.get(v).add(u);
        }

        int[] indegrees = new int[numCourses];
        for(int i=0;  i<numCourses; i++) {
            for(int it : adj.get(i)) {
                indegrees[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegrees[i] == 0) {
                q.add(i);
            }
        }

        int cnt = 0;

        while(!q.isEmpty()) {
            int node = q.poll();
            cnt++;

            for(int it: adj.get(node)) {
                indegrees[it]--;
                if(indegrees[it] == 0) {
                    q.add(it);
                }
            }
        } 

        if(cnt== numCourses) {
            return true;
        }

        return false;


    }
}