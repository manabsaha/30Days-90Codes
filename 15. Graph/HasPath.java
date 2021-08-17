/* Given an undirected graph with N vertices and E edges and two vertices (U, V) from the graph, the task is to detect if a path exists 
between these two vertices. Return “True” if a path exists and “False” otherwise. */

public boolean hasPath(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited){
		if(src==dest){
			return true;
		}
		visited[src] = true;
		for(Edge edge : graph[src]){
			if(visited[edge.end]==false){
				boolean path = hasPath(graph,edge.end,dest,visited);
				if(path==true){
					return true;
				}
			}
		}
		return false;
	}
