/* Dijkstra’s algorithm is used to find the shortest path from a single source vertex to all other vertices in the given graph. 
Approach: Same as BFS, but instead of queue, we use a min priority queue.
The code is for undirected graphs, the same Dijkstra function can be used for directed graphs also.
Dijkstra’s algorithm doesn’t work for graphs with negative weight cycles. For that, we use Bellman-Ford Algorithm.
Time: O(ElogV) */

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
		graph[0].add(new Edge(0,1,40));
		graph[0].add(new Edge(0,3,5));
		graph[1].add(new Edge(1,0,40));
		graph[1].add(new Edge(1,2,3));
		graph[1].add(new Edge(1,4,8));
		graph[2].add(new Edge(2,1,3));
		graph[2].add(new Edge(2,3,15));
		graph[2].add(new Edge(2,4,6));
		graph[3].add(new Edge(3,0,5));
		graph[3].add(new Edge(3,2,15));
		graph[3].add(new Edge(3,4,10));
		graph[4].add(new Edge(4,1,8));
		graph[4].add(new Edge(4,2,6));
		graph[4].add(new Edge(4,3,10));
	}

	public static void main(String[] args){
		int vertices = 5;
		//create graph
		ArrayList<Edge>[] graph = new ArrayList[vertices];
		//this is a function to create a adjacency list.
		createGraph(graph,vertices);
		
		//solution
		Solution obj = new Solution();
		int src = 0;
		boolean[] visited = new boolean[vertices];
		obj.djikstras(graph,src);
	}
}

class Solution 
{ 
	public static class Pair implements Comparable<Pair>{
		int v;
		String psf;
		int wsf;
		Pair(int v,String psf,int wsf){
			this.v = v;
			this.psf = psf;
			this.wsf = wsf;
		}

		public int compareTo(Pair o){
			return this.wsf - o.wsf;
		}
	}

	public void djikstras(ArrayList<Edge>[] graph,int src){
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[graph.length];
		pq.add(new Pair(src,src+"",0));
		while(pq.size()>0){
			Pair rem = pq.remove();
			if(visited[rem.v]==true){
				continue;
			}
			visited[rem.v] = true;
			System.out.println(rem.v + " via " + rem.psf + " @weight "+ rem.wsf);
			for(Edge e : graph[rem.v]){
				if(visited[e.end]==false){
					pq.add(new Pair(e.end,rem.psf+e.end,rem.wsf+e.weight));
				}
			}
		}
	}
} 
