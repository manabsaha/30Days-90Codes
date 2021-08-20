/*  Prim's algorithm is a greedy algorithm that finds a minimum spanning tree for a weighted undirected graph. This means it finds a 
subset of the edges that forms a tree that includes every vertex, where the total weight of all the edges in the tree is minimized.

It is same as Djikstra's algorithm but in place of maintaining path so far(psf) and weight so far(wsf), we maintain the acquiring vertex
and the weight of the current edge along with the vertex.

Eg. Nodes are laptops and cost is the length of wire required to connect the two nodes. We need to find the minimum length of wire 
needed if all nodes are to be connected in a LAN network. 

Time: O(ElogV) since adjacency list is being used. */

class Solution 
{ 
	public static class Pair implements Comparable<Pair>{
		int v;
		int parent;
		int wt;
		Pair(int v,int parent,int wt){
			this.v = v;
			this.parent = parent;
			this.wt = wt;
		}

		public int compareTo(Pair o){
			return this.wt - o.wt;
		}
	}

	public void prims(ArrayList<Edge>[] graph,int src){
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[graph.length];
		pq.add(new Pair(src,-1,0));
		while(pq.size()>0){
			Pair rem = pq.remove();
			if(visited[rem.v]==true){
				continue;
			}
			visited[rem.v] = true;
			if(rem.parent!=-1){
				System.out.println(rem.v + " via " + rem.parent + " @cost "+ rem.wt);				
			}
			for(Edge e : graph[rem.v]){
				if(visited[e.end]==false){
					pq.add(new Pair(e.end,rem.v,e.weight));
				}
			}
		}
	}
} 
