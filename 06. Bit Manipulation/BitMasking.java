/* Bit Masking:
1. Find  bit at iᵗʰ position 
2. Set bit at iᵗʰ position
3. Clear bit at iᵗʰ position */

public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
		System.out.println(obj.findBit(22,4)); //10110 -> 0
		System.out.println(obj.setBit(13,2)); //01101 -> 01111
		System.out.println(obj.clearBit(25,4)); //11001 -> 10001
	}
}

class Solution
{
	public int findBit(int a,int i){
		int mask = 1<<(i-1);
		a = a&mask;
		if(a==0) return 0;
		return 1;
	}

    public int setBit(int a,int i){
    	int mask = 1<<(i-1);
    	a = a|mask;
    	return a;
    }

    public int clearBit(int a,int i){
    	int mask = ~(1<<(i-1));
    	a = a&mask;
    	return a;
    }
}
