/* Given an input stream of N integers. The task is to insert these numbers into a new stream and find the median of the stream formed by 
each insertion of X to the new stream.
Eg.
Input:
N = 4
X[] = 5,15,1,3
Output:
5
10
5
4
Explanation:Flow in stream : 5, 15, 1, 3 
5 goes to stream --> median 5 (5) 
15 goes to stream --> median 10 (5,15) 
1 goes to stream --> median 5 (5,15,1) 
3 goes to stream --> median 4 (5,15,1 3) 
*/

class Solution
{
    static PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> right = new PriorityQueue<>();
    static int i = 1;
    
    //Function to insert heap.
    public static void insertHeap(int x)
    {
        if(i==1){
            left.add(x);
            i=2;
        }
        else{
            right.add(x);
            i=1;
        }
        balanceHeaps();
        //System.out.println(getMedian());
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
       if(left.isEmpty() || right.isEmpty()){
           return;
       }
       if(left.peek()>right.peek()){
           int l = left.poll();
           int r = right.poll();
           left.add(r);
           right.add(l);
       }
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        if(i==2){
            return left.peek();
        }
        double median = (left.peek()+right.peek())/2;
        return median;
    }
    
}
