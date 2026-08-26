package Graphs;

import java.util.*;

public class TraversalQuestions {

    public boolean isCycleBFS(List<List<Integer>> adj,
                              int source,
                              boolean[] visited) {

        Queue<Node> q = new LinkedList<>();

        q.add(new Node(source, -1));
        visited[source] = true;

        while (!q.isEmpty()) {

            Node curr = q.poll();

            int node = curr.first;
            int parent = curr.second;

            for (int neighbour : adj.get(node)) {

                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.add(new Node(neighbour, node));
                }
                else if (neighbour != parent) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isCycle(int V, List<List<Integer>> adj) {

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                if (isCycleBFS(adj, i, visited)) {
                    return true;
                }
            }
        }

        return false;
    }



}

class Node {
    int first;
    int second;
    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
