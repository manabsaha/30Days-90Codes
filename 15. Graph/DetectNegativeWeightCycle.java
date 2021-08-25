/* Given a weighted directed graph with n nodes and m edges. Nodes are labeled from 0 to n-1, the task is to check if it contains 
a negative weight cycle or not. Note: edges[i] is defined as u, v and weight. 
Return 1 if cycle found, else 0. */

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        return bellmanFord(edges,n,0);
    }
    
    public static int bellmanFord(int[][] edges,int n,int src){
		//setting distance to infinity
		int[] distance = new int[n];
		for(int i=0;i<n;i++) distance[i] = Integer.MAX_VALUE;
		distance[src] = 0;
		n-=1;
		while(n--!=0){
			for(int i=0;i<edges.length;i++){
				if(distance[edges[i][0]]!=Integer.MAX_VALUE && distance[edges[i][0]] + edges[i][2] < distance[edges[i][1]]){
					distance[edges[i][1]] = distance[edges[i][0]] + edges[i][2];
				}
			}
		}
		for(int i=0;i<edges.length;i++){
			if(distance[edges[i][0]]!=Integer.MAX_VALUE && distance[edges[i][0]] + edges[i][2] < distance[edges[i][1]]){
			    return 1;
			}
		}
		return 0;
	}
}
