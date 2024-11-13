package C13_graphs_2;
import java.util.*;
public class bellman_ford {
    public static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // initialise
        int[] distance = new int[V];
        for (int i = 0; i < V; i++){
            distance[i] = (int)1e8;
        }
        distance[S] = 0;

        // relaxation for v - 1 times
        for (int i = 0; i < V -1; i++){
            // relaxation (i.e update distance)
            for (ArrayList<Integer> edge : edges){
                int u = edge.get(0);
                int v = edge.get(1);
                int w = edge.get(2);
                if (distance[u] != (int)1e8 && distance[u] + w < distance[v]){
                    distance[v] = distance[u] + w;
                }
            }
        }
        // the distances are finalised after v - 1 cycles. Thus, after 𝑉 − 1 iterations, another relaxation of any edge is still possible, this indicates the presence of a negative-weight cycle.
        // cycle detection
        for (ArrayList<Integer> edge : edges){
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            if (distance[u] != (int)1e8 && distance[u] + w < distance[v]){
                return new int[]{-1};
            }
        }
        return distance;
    }
    public static void main(String[] args) {

    }
}
