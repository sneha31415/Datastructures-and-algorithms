package C13_graphs_2;

import java.util.Scanner;

public class dijkstras_algo {
    private static int get_min_vertex(int[] distance, boolean[] visited){
        int min_vertex = -1;
        for (int i = 0; i < visited.length; i++){
//            to avoid array index out of bound, we assign the first unvisited vertex as min_vertex using the "||" operation
            if (!visited[i] && (min_vertex == -1 || distance[i] < distance[min_vertex])){
                min_vertex = i;
            }
        }
        return min_vertex;
    }
    public static void dijkstras_algo(int[][] adjmatrix){
        int v = adjmatrix.length;
//      initialise
        int[] distance = new int[v];
//        set the dist for the source as 0
        distance[0] = 0;
        for (int i = 1; i < v; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        boolean[] visited = new boolean[v];

//        iterate over all the vertices
        for (int i = 0; i < v; i++){
            int min_vertex = get_min_vertex(distance, visited);
            visited[min_vertex] = true;
//            explore the unvisited neighbours
            for (int j = 0; j < v; j++){
//                dijkstra's works only for non negative edges
                if (adjmatrix[min_vertex][j] > 0 && !visited[j] && adjmatrix[min_vertex][j] != Integer.MAX_VALUE){ // the last check is just a caution to avoid getting negative after adding some +ve to infinity
//                    calculate dist to reach j via min vertex
                    int newDist = adjmatrix[min_vertex][j] + distance[min_vertex];
//                   check if min_vertex -> j is a better path
                    if (newDist < distance[j]){
                        distance[j] = newDist;
                    }
                }
            }
        }
//          print the min paths
        for (int vertex = 0; vertex < v; vertex++){
            System.out.println(vertex + " " + distance[vertex]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[][] adjmatrix = new int[v][v];
        for (int i = 0; i < e; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();
            adjmatrix[v1][v2] = weight;
            adjmatrix[v2][v1] = weight;
        }
        dijkstras_algo(adjmatrix);
    }
}
