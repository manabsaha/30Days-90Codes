/* All primes numbers in range of 2 to N. 
Method: Seive of Eratosthenes 
T(N) = N * N log(logN) */

public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
		boolean p[] = obj.primes(225);
		for(int i=0;i<p.length;i++){
			if(p[i]==true) System.out.println(i+" ");
		}
	}
}

class Solution{
	public boolean[] primes(int range){
		boolean prime[] = new boolean[range+1];
		for(int i=2;i<range+1;i++){
			prime[i] = true;
		}
		for(int i=2;i<=Math.sqrt(range);i++){
			if(prime[i]){
				for(int j=2;i*j<range+1;j++){
					prime[i*j] = false;
				}
			}
		}
		return prime;
	}
}
