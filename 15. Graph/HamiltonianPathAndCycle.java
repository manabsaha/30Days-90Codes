/* Hamiltonian Path in an undirected graph is a path that visits each vertex exactly once. A Hamiltonian cycle (or Hamiltonian circuit) 
is a Hamiltonian Path such that there is an edge (in the graph) from the last vertex to the first vertex of the Hamiltonian Path. 
Find all such paths and cycles from the initial vertex. */

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
		//this is a function to create a adjacency list.
		createGraph(graph,vertices);
		//solution
		Solution obj = new Solution();
		int src = 0;
		HashSet<Integer> visited = new HashSet<>();
		obj.hamiltonianPath(graph,src,visited,src+"",src);
	}
}

class Solution{

	public void hamiltonianPath(ArrayList<Edge>[] graph,int src,HashSet<Integer> visited,String psf,int osrc){
		//if hamiltonian path or cycle.
		if(visited.size()==graph.length-1){
			boolean cycle = false;
			for(Edge e : graph[src]){
				if(e.end==osrc){
					cycle = true;
					break;
				}
			}
			if(cycle==true){
				System.out.println("Cycle: "+psf);
			}
			else{
				System.out.println("Path: "+psf);
			}
			return;
		}
		//mark
		visited.add(src);
		//add
		for(Edge edge : graph[src]){
			if(visited.contains(edge.end)==false){
				hamiltonianPath(graph,edge.end,visited,psf+edge.end,osrc);
			}
		}
		//backtrack
		visited.remove(src);
	}
}
