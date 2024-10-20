package C13_graphs_2;

import java.util.Scanner;

public class prim_algo {
//    func to get the unvisited neighbour(of the last processed vertex) with the minimum weight
    private static int get_min_vertex(int[] weight, boolean[] visited){
//        dont assign min_vertex = 0; as "0" may be already a visited vertex
        int min_vertex = -1;
//        find the neighbour with the minimum most weight
//        it is sure to get a neighbour only of the last processed vertex bcz the processed vertex are marked visited and the ones not explored yet are having weight infinity
        for (int i = 0; i < weight.length; i++){
//            the vertices that have been visited have got their weights updated from infinity, so included !visited[i]
//            for the case when min_vertex = -1, i.e first case, the first "non visited index" is assigned as min_index
            if(!visited[i] && (min_vertex == -1 || weight[i] < weight[min_vertex])){
                min_vertex = i;
            }
        }
        return min_vertex;
    }
    public static void prim_algo(int[][] adjmatrix){
//        initialise
        int v = adjmatrix.length;
        int[] parent = new int[v];
        int[] weight = new int[v];
        boolean[] visited = new boolean[v]; //initialised to all false
//        considering source vertex as 0
        weight[0] = 0;
        parent[0] = -1;
        for (int i = 1; i < v; i++){
            weight[i] = Integer.MAX_VALUE;
        }
//        loop over the vertices
        for (int i = 0; i < v; i++){
//            intially all except 0 have weight = infinity, so min_vertex = 0
            int min_vertex = get_min_vertex(weight, visited);
            visited[min_vertex] = true;
//            loop over the neighbours of min vertex
//            since we are using an adj matrix so we run a loop from 0 to v-1 to check for neighbour
            for (int j = 0; j < v; j++){
//                adjmatrix[min_vertex][j] != 0 Considering the case of negative weights as well
                if (adjmatrix[min_vertex][j] != 0 && adjmatrix[min_vertex][j] < weight[j]){
//                    update the curr weight and parent
                        weight[j] = adjmatrix[min_vertex][j];
                        parent[j] = min_vertex;
                }
            }
        }
//        print the minimum spanning tree
        for (int i = 1; i < v; i++){
//            if (i < parent[i])
                System.out.println(i + " " + parent[i] + " " + weight[i]);
//            else
//                System.out.println(parent[i] + " " + i + " " + weight[i]);
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
        prim_algo(adjmatrix);
    }
}
