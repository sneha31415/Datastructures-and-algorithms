package C13_graphs_2;

import java.util.Arrays;
import java.util.Scanner;
class Edge implements Comparable<Edge>{
    int v1, v2, weight;

    Edge(){};
    Edge(int v1, int v2, int weight){
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }
    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }

    public class kruskal{
//        this will return the "ULTIMATE / topmost" parent
//        a parent is topmost when "v = parent[v]"
//        this is UNION FIND algorithm
        private static int get_parent(int v, int[] parent){
            if (v == parent[v]){
                return v;
            }
            return get_parent(parent[v], parent);
        }
        public static Edge[] kruskal_algorithm(Edge[] edges, int v){
//            step 2 : sort the edges in ascending order
            Arrays.sort(edges);
            Edge[] mst = new Edge[v - 1];
            int[] parent = new int[v];
//            initialise the parent array
            for (int i = 0; i < v; i++){
//            initially each vertex is from a different set, so they are parent of themselves
                parent[i] = i;
            }
            int count = 0;
            int i = 0;
//            add egdes until
            while(count != v - 1){
                Edge curr_edge = edges[i++];
                int v1_parent = get_parent(curr_edge.v1, parent);
                int v2_parent = get_parent(curr_edge.v2, parent);
//                same "topmost" parents implies being in the same connected component. As one connected component has one topmost parent.
                if (v1_parent != v2_parent){
                    mst[count++] = curr_edge;
//                    update the parents
//                    change the ultimate parent of v1 to ultimate parent of v2. as both are connected now
                    parent[v1_parent] = v2_parent;
                }
            }
            return mst;
        }
    }
    public static void main(String[] args) {
//        step1 prepare the input i.e the edgelist
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(); //num vertices
        int e = sc.nextInt(); //num edges

        Edge[] edges = new Edge[e];
        for (int i = 0; i < e; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();
            Edge edge = new Edge(v1, v2, weight);
            edges[i] = edge;
        }
        Edge[] mst = kruskal.kruskal_algorithm(edges, v);

        for (int i = 0; i < mst.length; i++){
            System.out.println(mst[i].v1 + " " + mst[i].v2);
        }
    }
}