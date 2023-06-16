//Longest word in a sentence

public class Main{
	public static void main(String[] args){
		int arr[] = {3,5,7,12,15,18};
		Solution obj = new Solution();
		obj.printLargestWord("Good morning folks");
	}
}

class Solution{
	public void printLargestWord(String s){
		int max = 0,maxStart=0;
		int n = s.length();
		int count = 0;
		int start= 0;
		for(int i=0;i<n;i++){
			if(s.charAt(i)==' '){
				start = i+1;
				count = 0;
			}
			else{
				count++;
				if(count>max){
					max = count;
					maxStart = start;
				}
			}
		}
		System.out.println("The longest word is: "+s.substring(maxStart,maxStart+max)+" and length is: "+max);
	}
}

