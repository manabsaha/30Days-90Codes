/* Suppose there is a circle. There are N petrol pumps on that circle. You will be given two sets of data.
1. The amount of petrol that every petrol pump has.
2. Distance from that petrol pump to the next petrol pump.
Find a starting point where the truck can start to get through the complete circle without exhausting its petrol in between.
Note :  Assume for 1 litre petrol, the truck can go 1 unit of distance.
Eg.
N = 4
Petrol = 4 6 7 4
Distance = 6 5 3 5
Output: 1 */

public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
		int petrol[] = {4,6,7,4};
		int distance[] = {6,5,3,5};
		System.out.println(obj.rearrange(arr,arr.length));
	}
}

class Solution
{
    int tour(int petrol[], int distance[]){
        int front = 0;
        int rear = 0;
        int n = petrol.length;
        int bal = 0;
        int count = 0;
        int i=0;
        while(count!=n && front!=n){
            if(front!=0 && rear==n){
                rear = 0;
            }
            bal = bal + petrol[rear] - distance[rear];
            i++;
            if(bal<0){
                front = i;
                rear = front;
                count = 0;
                bal = 0;
            }
            else{
                count++;
                rear++;
            }
        }
        if(front==n) return -1;
        return front;
    }
}
