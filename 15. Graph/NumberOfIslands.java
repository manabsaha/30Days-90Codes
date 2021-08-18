/* Given a grid consisting of '0's(Water) and '1's(Land). Find the number of islands.
Note: An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions. 

This is a variation of the standard problem: “Counting the number of connected components in an undirected graph”.

The problem can be easily solved by applying DFS() on each component. In each DFS() call, a component or a sub-graph is visited. 
We will call DFS on the next un-visited component. The number of calls to DFS() gives the number of connected components. BFS can also be used. */

class Solution
{
    //Function to find the number of islands.
    public int numIslands(char[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    findIsland(grid,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }
    
    static public void findIsland(char[][] graph,int i,int j,boolean[][] visited){
        //base case
        if(i<0 || i>=graph.length || j<0 || j>=graph[0].length || 
                graph[i][j]=='0' || visited[i][j]==true){
            return;
        }
        //mark
        visited[i][j] = true;
        //horizontal and vertical direction
        findIsland(graph,i-1,j,visited);
        findIsland(graph,i,j+1,visited);
        findIsland(graph,i,j-1,visited);
        findIsland(graph,i+1,j,visited);
        //diagonal direction
        findIsland(graph,i-1,j-1,visited);
        findIsland(graph,i-1,j+1,visited);
        findIsland(graph,i+1,j-1,visited);
        findIsland(graph,i+1,j+1,visited);
    }
    
}
