package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traversal {

    public List<Integer> bfs(List<List<Integer>> adj) {
        int n = adj.size() - 1;

        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];

        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }

        return ans;
    }

    public List<Integer> dfs(List<List<Integer>> adj) {
        int n = adj.size() - 1;

        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];

        dfsHelper(1, adj, visited, ans);

        return ans;
    }

    private void dfsHelper(
            int node,
            List<List<Integer>> adj,
            boolean[] visited,
            List<Integer> ans) {

        visited[node] = true;
        ans.add(node);

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, adj, visited, ans);
            }
        }
    }

    public List<Integer> bfs(int[][] matrix) {
        int n = matrix.length - 1;

        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];

        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for (int neighbor = 1; neighbor <= n; neighbor++) {
                if (matrix[node][neighbor] == 1 && !visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }

        return ans;
    }

    public List<Integer> dfs(int[][] matrix) {
        int n = matrix.length - 1;

        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];

        dfsHelper(1, matrix, visited, ans);

        return ans;
    }

    private void dfsHelper(
            int node,
            int[][] matrix,
            boolean[] visited,
            List<Integer> ans) {

        visited[node] = true;
        ans.add(node);

        int n = matrix.length - 1;

        for (int neighbor = 1; neighbor <= n; neighbor++) {
            if (matrix[node][neighbor] == 1 && !visited[neighbor]) {
                dfsHelper(neighbor, matrix, visited, ans);
            }
        }
    }
    
}
