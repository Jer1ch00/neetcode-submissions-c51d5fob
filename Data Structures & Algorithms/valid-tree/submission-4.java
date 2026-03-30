class Solution {
    public boolean validTree(int n, int[][] edges) {
        // A tree must have exactly n - 1 edges
        if (edges.length != n - 1) return false;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];

        // Only ONE DFS needed
        if (!dfs(0, -1, visited, adj)) return false;

        // Ensure all nodes are connected
        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }

    private boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (!dfs(neighbor, node, visited, adj)) {
                    return false;
                }
            } else if (neighbor != parent) {
                // Cycle detected
                return false;
            }
        }

        return true;
    }
}