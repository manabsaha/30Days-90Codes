/* The intersection of two arrays contains the elements common to both the arrays. The intersection should not count duplicate elements.
Given two sorted arrays arr1[] and arr2[] of sizes N and M respectively. Find their intersection
Technique: Merging two sorted array approach */

public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
		int arr1[] = {2,2,2,2,2,4,5,8,9,10,10,15};
		int arr2[] = {2,2,2,2,4,6,6,8,10,12,15,18};
		ArrayList<Integer> union = obj.findIntersection(arr1,arr2,arr1.length,arr2.length);
        for(int item:union) System.out.print(item+" ");
	}
}

class Solution
{
    public static ArrayList<Integer> findIntersection(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer> union = new ArrayList<>();
        int j=0,k=0;
        if(arr1[0]>arr2[0]){
        	k++;
        }else if(arr1[0]==arr2[0]){
        	union.add(arr1[0]);
        	j++;
        	k++;
        }
        else{
        	j++;
        }
        for(int i=1;i<n+m;i++){
            if(j==n || k==m){
                break;
            }
            else if(arr1[j]<arr2[k]){
                j++;
            }
            else if(arr1[j]==arr2[k]){
            	if(union.size()!=0){
            		if(union.get(union.size()-1) != arr1[j])
            			union.add(arr1[j]);
            	}
            	else{
            		union.add(arr1[j]);
            	}
                j++;
                k++;
            }
            else if(arr1[j]>arr2[k]){
                k++;
            }
        }
        return union;
    }
}
