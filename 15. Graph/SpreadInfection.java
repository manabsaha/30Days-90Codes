/* Count the number of infection of disease if it spreads to all person at 1 distance in every 1 unit of time from every infected person.
Given time and graph as input, calculate infection count.
Approach: Use BFS and traverse to radius 'time'. */

class Solution 
{ 
	class Pair{
		int v;
		int time;
		Pair(int v,int time){
			this.v = v;
			this.time = time;
		}
	}

    public int spreadInfection(ArrayList<Edge>[] graph,int src,boolean[] visited,int time){
    	Queue<Pair> queue = new LinkedList<>();
    	queue.add(new Pair(src,1));
    	int count = 0;
    	while(queue.size()>0){
    		Pair rem = queue.poll();
    		if(visited[rem.v]==true){
    			continue;
    		}
    		visited[rem.v] = true;
    		if(rem.time>time){
    			break;
    		}
    		// System.out.println(rem.v+" infected");
    		count++;
    		for(Edge e : graph[rem.v]){
    			if(visited[e.end]==false){
    				queue.add(new Pair(e.end,rem.time+1));
    			}
    		}
    	}
    	return count;
    }
} 
