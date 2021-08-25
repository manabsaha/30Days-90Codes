/* Bellman Ford: Shortest path using the negative weights.
Approach: Relax all the edges for V-1 times.
Output: [0, -2, 8, 5]
Time: In average cases, O(n²) time is required, but if the graph is complete i.e., having 
n(n-1)/2 edges, then it'll take O(n³) time. */

/* To detect negative cycle, run relaxtion one more time.
If distance array remains unchanges for each node, then the graph does not contain negative cycle. */

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

	public static void createGraph(ArrayList<Edge>[] graph,int v){
		for(int i=0;i<v;i++){
			graph[i] = new ArrayList<Edge>();
		}
		graph[0].add(new Edge(0,1,4));
		graph[0].add(new Edge(0,3,5));
		graph[2].add(new Edge(2,1,-10));
		graph[3].add(new Edge(3,2,3));
	}

	public static void main(String[] args){
		int vertices = 4;
		//create graph
		ArrayList<Edge>[] graph = new ArrayList[vertices];
		//this is a function to create a adjacency list.
		createGraph(graph,vertices);
		//solution
		Solution obj = new Solution();
		int src = 0;
		obj.bellmanFord(graph,src);
	}
}

class Solution 
{

	public static void bellmanFord(ArrayList<Edge>[] graph,int src){
		int n = graph.length;
		//setting distance to infinity
		int[] distance = new int[n];
		for(int i=0;i<n;i++) distance[i] = Integer.MAX_VALUE;
		distance[src] = 0;
		//list of all edges
		ArrayList<Edge> edges = new ArrayList<>();
		for(int i=0;i<n;i++){
			for(Edge e : graph[i]){
				edges.add(e);
			}
		}
		n-=1; //for n-1 times
		while(n--!=0){
			//relaxation
			for(Edge e : edges){
				if(distance[e.start] + e.weight < distance[e.end]){
					distance[e.end] = distance[e.start] + e.weight;
				}
			}
		}
		System.out.println(Arrays.toString(distance));
	}
} 
