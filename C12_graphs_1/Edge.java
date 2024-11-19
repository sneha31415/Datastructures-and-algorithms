package C12_graphs_1;

/*
    1. Take input and store graph
    2. Store edges in ascending order of weights
    3. count = 0
    while
*/
class Edge implements Comparable<Edge> {
    int v1, v2, weight;

    Edge(int v1, int v2, int weight) {
        this.v1 = v2;
        this.v2 = v2;
        this.weight = weight;
    }

//    Arrays.sort works fine for wrapper classes but doesnt know how to compare edges
    @Override
    public int compareTo(Edge o) {
        //return a positive value if weight of first edge is larger
        return this.weight - o.weight;
    }
}
