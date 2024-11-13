package C12_graphs_1;

import java.util.*;

public class graphs {
    public static void dfsTraversalHelper(int [][] adjMatrix, int currVertex, boolean visited[]){
        visited[currVertex] = true;
        System.out.print(currVertex + " ");
//        visit every vertex
        for(int i = 0; i<adjMatrix.length; i++){
            if(adjMatrix[currVertex][i] == 1 && !visited[i]){
//                visit that vertex's children
                dfsTraversalHelper(adjMatrix, i, visited);
            }
        }

        //BETTER IMPROVISATION BELOW
        /*System.out.println();
        for(int i = 0; i< visited.length; i++) {
            if(!visited[i]){
                dfsTraversal(adjMatrix, i, visited);
            }
        }*/
    }
    public static void dfsTraversal(int [][] adjMatrix){
        boolean visited[] = new boolean[adjMatrix.length];
        for(int i = 0; i < adjMatrix.length; i++){
            if(!visited[i]){
                dfsTraversalHelper(adjMatrix, i, visited); //this will print all the connected components of i
                System.out.println();
            }
        }

    }



    public static void bfsTraversal(int [][] adjMatrix){
        Queue<Integer> pending = new LinkedList<>();
        boolean visited[] = new boolean[adjMatrix.length];

        //call for each component
        for(int i = 0; i< adjMatrix.length; i++) {
//            ensure that all connected component are covered
            if (!visited[i]) {
                pending.add(i);
                visited[i] = true;
//                bfs
                while (!pending.isEmpty()) {
                    int currVertex = pending.poll();
                    System.out.print(currVertex + " ");

                    //calling on the children of the connected component
                    for (int j = 0; j < adjMatrix.length; j++) {
                        if (adjMatrix[currVertex][j] == 1 && !visited[j]) {
                            //the moment you add a vertex in pending Queue, mark it as visited in the visited[] array
                            pending.add(j);
                            visited[j] = true;
                        }
                    }
                }
                System.out.println();//call of one whole connected componet is done so print a new line
            }
        }
    }



    //is there a need of current vertex in the below problem?
    public static boolean hasPathDFS(int [][] adjMatrix, boolean [] visited, int currVertex, int source, int destination){
        visited[currVertex] = true;

        //check for out of bounds
        if(source >= (adjMatrix.length) || destination >= (adjMatrix.length)){
            return false;
        }
        //checking for a direct path
        if(adjMatrix[source][destination] == 1){
            return true;
        }

        for(int i = source; i<adjMatrix.length; i++){
            if(adjMatrix[currVertex][i] == 1 && !visited[i]){
               if(i==destination)
                    return true;
                 }
                else{
                hasPathDFS(adjMatrix, visited, i, source, destination);
            }
        }
    return false;
    }

    //chat gpt
    /*public static boolean hasPathDFS(int[][] adjMatrix, boolean[] visited, int currVertex, int source, int destination) {
        // Check for out of bounds
        if (source >= adjMatrix.length || destination >= adjMatrix.length) {
            return false;
        }

        // Check if we are at the destination
        if (currVertex == destination) {
            return true;
        }

        // Mark the current vertex as visited
        visited[currVertex] = true;

        // Traverse all adjacent vertices
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[currVertex][i] == 1 && !visited[i]) {
                // Recursive call to visit the next vertex
                if (hasPathDFS(adjMatrix, visited, i, source, destination)) {
                    return true;
                }
            }
        }

        // No path found
        return false;
    } */

    public static boolean hasPathDFS(int [][] adjMatrix, int source, int destination){
      boolean visited[]= new boolean[adjMatrix.length];
        return hasPathDFS(adjMatrix, visited, source, source, destination);
    }

    public static boolean hasPathBFS(int [][] adjMatrix, boolean [] visited, int source, int destination){
        //check for out of bounds
        if(source >= (adjMatrix.length) || destination >= (adjMatrix.length)){
            return false;
        }

        //check for direct path
        if(adjMatrix[source][destination] == 1){
            return true;
        }

        Queue<Integer> pending = new LinkedList<>();
        pending.add(0);
        visited[0] = true;

        while(!pending.isEmpty()){
            int currentVertex = pending.poll();
            for(int i = source; i< adjMatrix.length; i++){
                if(adjMatrix[currentVertex][i] == 1 && !visited[i]){
                    if( i == destination)
                        return true;
                    else {
                        pending.add(i);
                        visited[i] = true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean hasPathBFS(int [][] adjMatrix, int source, int destination){
        boolean visited[] = new boolean[adjMatrix.length];
        return hasPathBFS(adjMatrix, visited,source, destination);
    }



    public static ArrayList getPathBFSHelper(int [][] adjMatrix, boolean [] visited, int s, int e){
        //NOTE= HERE WE WILL NOT CHECK FOR DISCONNECTED GRAPHS CUZ IF s and e ARE NOT IN THE SAME CONNECTED GRAPH THEN THERE CANNOT EXIST A PATH BETWEEN THEM

        Queue <Integer>pending  = new LinkedList<>();
        visited = new boolean[adjMatrix.length];
        HashMap<Integer, Integer> map =new HashMap<>();
        ArrayList <Integer> ans = new ArrayList<>();

        if(s >= adjMatrix.length || e >= adjMatrix.length){
            return null;
        }
        if(adjMatrix[s][e] == 1 && s == e){
            ans.add(s);
            return ans;
        }

        pending.add(s);
        visited[s] = true;
        while(!pending.isEmpty()){
            int currVertex = pending.poll();
            for(int i = 0; i<adjMatrix.length; i++){
                if(adjMatrix[currVertex][i] == 1 && !visited[i]){
                    pending.add(i);
                    visited[i] = true;
                    map.put(i, currVertex);

                    if(i == e){
                        ans.add(i);
                        int value = map.get(e);
                        while(value != s){
                            ans.add(value);
                            value = map.get(value);
                        }
                        ans.add(value); // equivalent to ans.add(s);
                        return ans;
                    }
                }
            }
        }
        return null;
    }
    public static ArrayList getPathBFS(int [][] adjMatrix, int s, int e){
        boolean[] visited = new boolean[adjMatrix.length];
        return getPathBFSHelper(adjMatrix, visited, s, e);
    }



    public static ArrayList getPathDFSHelper(int [][] adjMatrix, boolean [] visited, int s, int e){
        //this condition in the recursive step is the base case, it means we reached destination from the source
        if(s == e){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(s);
            return ans;
        }

        visited[s] = true;

        for(int i = 0; i< adjMatrix.length; i++){
            if(adjMatrix[s][i] == 1 && !visited[i]){
                ArrayList<Integer> smallAns = getPathDFSHelper(adjMatrix, visited, i, e);

                if(smallAns != null){
                    smallAns.add(s);
                    return smallAns;
                }
            }
        }
        return null;
    }

    public static ArrayList getPathDFS(int [][] adjMatrix, int s, int e){
        boolean visited [] = new boolean[adjMatrix.length];
        return getPathDFSHelper( adjMatrix, visited, s, e);
    }


    public static boolean isConnectedDFSHelper(int [][] adjMatrix, int currVertex, boolean [] visited){
        /*visited[currVertex] = true;
        for(int i = 0; i< adjMatrix.length; i++){
            if(adjMatrix[currVertex][i] == 1 && !visited[i]){
                isConnectedDFSHelper(adjMatrix, i, visited);
            }
        }*/

        dfsTraversalHelper(adjMatrix,0,visited);

        for(int i = 0; i< visited.length; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
    public static boolean isConnectedDFS(int [][] adjMatrix) {
        boolean visited[] = new boolean[adjMatrix.length];
        return isConnectedDFSHelper(adjMatrix, 0, visited);
    }


    public static boolean isConnectedBFSHelper(int [][] adjMatrix, boolean [] visited){
        Queue<Integer> pending = new LinkedList<>();
        pending.add(0);
        visited[0] = true;

        while(!pending.isEmpty()){
            int currVertex = pending.poll();
            for(int i = 0; i<adjMatrix.length; i++) {
                if(adjMatrix[currVertex][i] == 1 && !visited[i]) {
                    pending.add(i);
                    visited[i] = true;
                }
            }
        }
        for(int i =0; i<visited.length; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
    public static boolean isConnectedBFS(int [][] adjMatrix){
        boolean visited[] = new boolean[adjMatrix.length];
        return isConnectedBFSHelper(adjMatrix, visited);
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); //n = no. of vertices
        int e = s.nextInt(); //e = no. of edges
        int adjMatrix[][] = new int[n][n]; // by default all cells are 0
        for(int i =0; i<e; i++){
            //we have to take input of each edge and each edge contains two vertices
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            //now fill the array
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n ; j++){
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
        bfsTraversal(adjMatrix);
        // System.out.println(hasPathBFS(adjMatrix, 2, 3));
        //System.out.println(hasPathDFS(adjMatrix, 0, 4));

//        ArrayList<Integer> path = new ArrayList<>();
//        path= getPathBFS(adjMatrix, 0,3);
//        for(int i =0; i< path.size(); i++){
//            System.out.print(path.get(i) + " ");
//        }

        System.out.println();
        System.out.println();
        ArrayList<Integer> path2 = new ArrayList<>();
        path2= getPathDFS(adjMatrix, 0,3);
        for(int i =0; i< path2.size(); i++){
            System.out.print(path2.get(i) + " ");
        }

        System.out.println(isConnectedDFS(adjMatrix));
        System.out.println(isConnectedBFS(adjMatrix));
    }
}
