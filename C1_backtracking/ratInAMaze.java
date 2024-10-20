package C1_backtracking;

public class ratInAMaze {
    public static boolean ratInAMaze(int maze[][]){
        int n = maze.length;//gives no. rows but here no of rows = no of cols so we are not doing maze[0].length here for number of cols
        int path[][]= new int[n][n];
        return solveMaze(maze,0,0,path);
    }
    public static boolean solveMaze(int maze[][],int i,int j,int path[][]){
        int n = maze.length;
        //check if i,j is a valid cell or not
        if(i<0||i>=n||j<0||j>=n||maze[i][j]==0||path[i][j]==1){
            return false;
        }
        //include the cell in current path
        path[i][j]=1;
        // check if destination cell has reached
        if(i==n-1 && j==n-1){
            for(int k=0;k< path.length;k++){
                for(int l=0;l<path[0].length;l++){
                    System.out.print(path[k][l]+" ");
                }
                System.out.println();
            }
            return true;
        }
        //explore all available paths
        if(solveMaze(maze,i-1,j,path)){
            return true;
        }
        if(solveMaze(maze,i,j+1,path)){
            return true;
        }
        if(solveMaze(maze,i+1,j,path)){
            return true;
        }if(solveMaze(maze,i,j-1,path)){
            return true;
        }
        path[i][j] = 0;
        return false;
    }

    public static void main(String[] args) {
        int maze[][] ={{1,1,0},{1,1,1},{1,1,1}};
        boolean ans = ratInAMaze(maze);
        System.out.println(ans);
    }
}
