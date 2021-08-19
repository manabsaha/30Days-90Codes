/* Detect whether a graph is cyclic or not. The graph can have more than one component.
Approach: Use Breadth First Search to span by radius and cover every vertex. If a node is visited again, it means 
the graph contains cycle. */

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
		boolean[] visited = new boolean[vertices];
		boolean cycle = false;
		for(int i=0;i<vertices;i++){
			if(visited[i]==false){
				cycle = obj.detectCycle(graph,src,visited);
				if(cycle==true){
					break;
				}
			}
		}
		System.out.println("Contains cycle: "+cycle);
	}
}

class Solution 
{ 
    public boolean detectCycle(ArrayList<Edge>[] graph,int src,boolean[] visited){
    	Queue<Integer> queue = new LinkedList<>();
    	queue.add(src);
    	while(queue.size()>0){
    		int v = queue.poll();
    		if(visited[v]==true){
    			return true;
    		}
    		visited[v] = true;
    		for(Edge e : graph[v]){
    			if(visited[e.end]==false){
    				queue.add(e.end);
    			}
    		}
    	}
    	return false;
    }
} 
