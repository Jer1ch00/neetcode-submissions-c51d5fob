
// Computes the minimum time for a signal to reach all nodes
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int[] t : times) graph.get(t[0]).add(new int[]{t[1], t[2]});

        // Initialize distance array with max value
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // start at node k
        dist[k] = 0; 

        // Min-heap priority queue {distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, k});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], u = curr[1];

            // Skip if we already have a shorter distance
            if (d > dist[u]) continue;

            // Traverse neighbors
            for (int[] edge : graph.get(u)) {
                int v = edge[0], w = edge[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }

        // Find the maximum distance
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            // unreachable
            if (dist[i] == Integer.MAX_VALUE) return -1; 
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}

