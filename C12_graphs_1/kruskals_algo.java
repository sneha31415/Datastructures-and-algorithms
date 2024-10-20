package C12_graphs_1;

import java.util.Arrays;
import java.util.Scanner;

public class kruskals_algo {
    public static int findParent(int v, int parent[]) {
        if (v == parent[v]) { //checking if the vertex is the topmost vertex itself
            return v;
        }
        //else find the parent of v's parent
        return findParent(parent[v], parent);
    }
    public static Edge[] kruskalAlgorithm(Edge[] edges, int n) {
    //sort the edges
        Arrays.sort(edges);
        Edge mst[] = new Edge[n - 1];
        int parent[] = new int[n];
        for(int j = 0; j<n ; j++) {
            //initialise parent array
        parent[j] = j ;
        }
        int count = 0, i = 0;
        while(count != n - 1 && i< edges.length){
            Edge currentEdge = edges[i++]; //use i then increment
            //now deciding if we have to include this edge using union find algo;
            int v1Parent = findParent(currentEdge.v1, parent);
            int v2Parent = findParent(currentEdge.v2, parent);
            if ( v1Parent != v2Parent ) {
                mst[count] = currentEdge;
                count++;
                //update parent of v1 to v2 or v2 to v1
                parent[v1Parent] = v2Parent;
              }
            }
        return mst;
        }


    public static void main(String[] args) {
         Scanner s = new Scanner(System.in);
         int n = s.nextInt();
         int e = s.nextInt();
         //array to store the edges
         Edge[] edges = new Edge[e];
         //taking input for all edges
         for(int i = 0; i<e; i++) {
             int v1 = s.nextInt();
             int v2 = s.nextInt();
             int weight = s.nextInt();
             Edge ed = new Edge(v1, v2, weight);
             edges[i] = ed;
         }

         //printing the result
         // MST array
        Edge[] mst= kruskalAlgorithm(edges, n);

         for(int i = 0; i < mst.length-1; i++){
             if(mst[i].v1 < mst[i].v2){
                 System.out.println(mst[i].v1 +" "+ mst[i].v2 + " " + mst[i].weight);
             }else{
                 System.out.println(mst[i].v2 +" "  +mst[i].v1 + " " + mst[i].weight);
             }
         }
    }

}
