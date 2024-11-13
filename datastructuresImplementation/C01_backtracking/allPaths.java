package C1_backtracking;

public class allPaths {
        public static void ratInAMaze(int maze[][]){
            int n = maze.length;//gives no. rows but here no of rows = no of cols so we are not doing maze[0].length here for number of cols
            int path[][]= new int[n][n];
            PrintAllPaths(maze,0,0,path);
        }

    //we are keeping func as void buz path hoga to print hojaega and nahi hoga to kuch print nahi hoga
        public static void PrintAllPaths(int maze[][],int i,int j,int path[][]){
            int n = maze.length;
            //check if i,j is a valid cell or not
            if(i<0||i>=n||j<0||j>=n||maze[i][j]==0||path[i][j]==1){
                return ;
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
                System.out.println();
                //resetting destination path variable to zero
                path[i][j]=0;
                return ;
            }
            //explore all available paths
            //top
            PrintAllPaths(maze,i-1,j,path);
            //right
            PrintAllPaths(maze,i,j+1,path);
            //down
            PrintAllPaths(maze,i+1,j,path);
            //left
            PrintAllPaths(maze,i,j-1,path);
            path[i][j]=0;


        }

        public static void main(String[] args) {
            int maze[][] ={{1,1,0},{1,0,0},{1,1,1}};
            ratInAMaze(maze);
            System.out.println("-----");
            int maze2[][]= {{1,1,0},{1,1,0},{1,1,1}};
            ratInAMaze(maze2);
        }
    }


