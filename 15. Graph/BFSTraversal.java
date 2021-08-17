import java.util.*;
import java.util.Queue;

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
		for(int i=0;i<vertices;i++){
			graph[i] = new ArrayList<Edge>();
		}
		
		graph[0].add(new Edge(0,4,40));
		graph[0].add(new Edge(0,1,40));
		graph[1].add(new Edge(1,0,40));
		graph[1].add(new Edge(1,3,40));
		graph[1].add(new Edge(1,2,40));
		graph[2].add(new Edge(2,1,40));
		graph[2].add(new Edge(2,4,40));
		graph[2].add(new Edge(2,3,40));
		graph[3].add(new Edge(3,1,40));
		graph[3].add(new Edge(3,2,40));
		graph[3].add(new Edge(3,4,40));
		graph[4].add(new Edge(4,0,40));
		graph[4].add(new Edge(4,2,40));
		graph[4].add(new Edge(4,3,40));
		
		//bfs traversal
		Solution obj = new Solution();
		int starting = 2;
		obj.BFS(graph,starting);
	}
}

class Solution{

	class Pair{
		int v;
		String path;
		Pair(int v,String path){
			this.v = v;
			this.path = path;
		}
	}

	public void BFS(ArrayList<Edge>[] graph,int starting){
		int n = graph.length;
		boolean[] visited = new boolean[n];
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(starting,starting+""));
		while(q.size()>0){
			//remove
			Pair temp = q.poll();
			//mark*
			if(visited[temp.v]==true){
				continue;
			}
			visited[temp.v] = true;
			//work
			System.out.println("Vertex: "+ temp.v + " @Path: " + temp.path);
			//add*
			for(Edge e : graph[temp.v]){
				if(visited[e.end]==false){
					q.add(new Pair(e.end,temp.path+e.end));
				}
			}
		}
	}
}
