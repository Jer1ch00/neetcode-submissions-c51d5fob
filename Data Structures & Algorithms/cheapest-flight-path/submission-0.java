class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        if(src == dst){ // edgecase you dont have to go anywhere
            return 0;
        }
        // To store the graph
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Adding edges to the graph
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        
        // To store minimum distance
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        
        /* Queue storing the elements of 
        the form {stops, {node, dist}} */
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, src, 0});
        
        while (!q.isEmpty()) {
            
            // Get the element from the queue
            int[] p = q.poll();
            
            int stops = p[0]; // stops
            int node = p[1]; // node
            int dist = p[2]; // distance
            
            /* If the number of stops taken exceed k, 
            skip and move to the next element */
            if (stops > k) continue;
            
            // Traverse all the neighbors
            for (int[] neighbor : adj.get(node)) {
                
                int adjNode = neighbor[0]; // Adjacent node
                int edgeWt = neighbor[1]; // Edge weight
                
                /* If the tentative distance to 
                reach adjacent node is smaller 
                than the known distance and number 
                of stops doesn't exceed k */
                if (dist + edgeWt < minDist[adjNode] && 
                    stops <= k) {
                    
                    // Update the known distance
                    minDist[adjNode] = dist + edgeWt;
                    
                    // Add the new element to the queue
                    q.offer(new int[]{stops + 1, adjNode, dist + edgeWt});
                }
            }
        }
        
        // If the destination is unreachable, return -1
        if (minDist[dst] == Integer.MAX_VALUE) 
            return -1;
        
        // Otherwise, return the result
        return minDist[dst];
        
    }
}