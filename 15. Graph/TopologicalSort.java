/* Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u v, 
vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG. 
Approach: We can modify DFS to find Topological Sorting of a graph. In DFS, we start from a vertex, we first print it and then 
recursively call DFS for its adjacent vertices. In topological sorting, we use a temporary stack. We don’t print the vertex immediately, 
we first recursively call topological sorting for all its adjacent vertices, then push it to a stack. Finally, print contents of the stack. */

import java.util.*;
import java.util.Stack;
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
		graph[1].add(new Edge(1,2,3));
		graph[1].add(new Edge(1,4,8));
		graph[2].add(new Edge(2,3,15));
		graph[3].add(new Edge(3,0,5));
		graph[3].add(new Edge(3,4,10));
		graph[4].add(new Edge(4,2,6));
	}

	public static void main(String[] args){
		int vertices = 5;
		//create graph
		ArrayList<Edge>[] graph = new ArrayList[vertices];
		//this is a function to create a adjacency list.
		createGraph(graph,vertices);
		
		//solution
		Solution obj = new Solution();
		boolean[] visited = new boolean[graph.length];
		Stack<Integer> st = new Stack<>();
		for(int i=0;i<vertices;i++){
			if(visited[i]==false){
				obj.topologicalSort(graph,i,visited,st);
			}
		}
		while(!st.isEmpty()){
			System.out.print(st.pop() + " ");
		}
	}
}

class Solution 
{
	public static void topologicalSort(ArrayList<Edge>[] graph,int src,boolean[] visited,Stack<Integer> st){
		visited[src] = true;
		for(Edge e : graph[src]){
			if(visited[e.end]==false){
				topologicalSort(graph,e.end,visited,st);
			}
		}
		st.push(src);
	}
} 
