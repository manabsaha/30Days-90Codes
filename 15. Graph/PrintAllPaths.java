/* Print all paths from source to destination in a graph.
Approach: Do a DFS Traversal and while backtracking mark the visited node false so that it can explore other ways. */

import java.util.*;
class Edge{
	int start;
	int end;
	int weight;
	Edge(int start,int end,int weight){
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}

public class Graph{

	public static void main(String[] args){
		int vertices = 5;
		//create graph
		ArrayList<Edge>[] graph = new ArrayList[vertices];
		createGraph(graph,vertices);
		
		Solution obj = new Solution();
		int src = 0;
		int dest = 4;
		boolean[] visited = new boolean[vertices];
		obj.findAllPath(graph,src,dest,visited,src+"");
	}
}

class Solution{

	public void findAllPath(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited,String psf){
		if(src==dest){
			System.out.println(psf);
			return;
		}
		//mark
		visited[src] = true;
		//add
		for(Edge edge : graph[src]){
			if(visited[edge.end]==false){
				findAllPath(graph,edge.end,dest,visited,psf+edge.end);
			}
		}
		//backtrack
		visited[src] = false;
	}
}
