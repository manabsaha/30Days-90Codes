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
		graph[0].add(new Edge(0,4,40));
		graph[0].add(new Edge(0,1,40));
		graph[1].add(new Edge(1,0,40));
		graph[2].add(new Edge(2,3,40));
		graph[3].add(new Edge(3,2,40));
		graph[4].add(new Edge(4,0,40));
	}

	public static void main(String[] args){
		int vertices = 5;
		//create graph
		ArrayList<Edge>[] graph = new ArrayList[vertices];
		createGraph(graph,vertices);
		
		Solution obj = new Solution();
		//connected components
		boolean[] visited = new boolean[vertices];
		ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
		for(int i=0;i<vertices;i++){
			if(visited[i]==false){
				ArrayList<Integer> component = new ArrayList<>();
				obj.connectedComponents(graph,i,visited,component);
				comps.add(component);
			}
		}
		
    for(ArrayList c : comps){
			System.out.println(Arrays.toString(c.toArray()));
		}
	}
}

class Solution{

	public void connectedComponents(ArrayList<Edge>[] graph,int src,boolean[] visited,ArrayList<Integer> component){
		visited[src] = true;
		component.add(src);
		for(Edge e : graph[src]){
			if(visited[e.end]==false){
				connectedComponents(graph,e.end,visited,component);
			}
		}
	}
  
}
