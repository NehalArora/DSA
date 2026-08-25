package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Introduction {
    /**
     * Representing a graph
     * There are 2 ways
     * 1. Adjacency matrix
     * 2. Adjacency list
     *
     * Using 1-based indexing
     * */

    public int[][] adjMatrix(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = sc.nextInt();
        System.out.println("Enter number of edges");
        int m = sc.nextInt();

        int[][] adj = new int[n+1][n+1];


        for (int j = 0; j < m; j++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u][v] = 1;
            adj[v][u] = 1;
        }


        return adj;
    }

    public List<Integer>[] adjList(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = sc.nextInt();
        System.out.println("Enter number of edges");
        int m = sc.nextInt();

        List<Integer>[] adj = new ArrayList[n + 1];

        for(int i = 0 ; i <= n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        return adj;
    }

    /**
     * A connected component is a subgraph of a graph in which there exists a path between
     * any two vertices, and no vertex of the subgraph shares an edge with a vertex
     * outside of the subgraph.
     *
     * Input:V = 7, edges = [[0, 1], [1, 2], [2, 3], [4, 5]]
     * Output: 3
     * Explanation: The edges [0, 1], [1, 2], [2, 3] form a connected component with
     * vertices {0, 1, 2, 3}
     * The edge [4, 5] forms another connected component with vertices {4, 5}.
     * Therefore, the graph has 3 connected components: {0, 1, 2, 3}, {4, 5}, and the
     * isolated vertices {6}.
     *
     * Using 0-based indexing
     * */
    public int connectedComponents(int V, int[][] edges){
        // Create adjacency list from edge list
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i <=V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        //Array to keep track of visited node
        boolean[] visited = new boolean[V];

        //To count the components
        int components = 0;

        for(int i = 0 ; i < V; i++){
            if (!visited[i]) {
                components++;

                // Visit entire component
                //bfs(i, adj, visited);
            }
        }
        return components;
    }

}
