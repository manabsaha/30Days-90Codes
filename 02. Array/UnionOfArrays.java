/* Union of two arrays can be defined as the common and distinct elements in the two arrays.
Given two sorted arrays of size n and m respectively, find their union. */

public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
		int arr1[] = {2,4,5,8,9,10,10,15};
		int arr2[] = {0,4,6,6,8,10,12,15,18};
		ArrayList<Integer> union = obj.findUnion(arr1,arr2,arr1.length,arr2.length);
        for(int item:union) System.out.print(item+" ");
	}
}
//User function Template for Java

//arr1,arr2 : the arrays
// n, m: size of arrays
class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer> union = new ArrayList<>();
        int j=0,k=0;
        if(arr1[0]>arr2[0]){
        	union.add(arr2[0]);
        	k++;
        }else if(arr1[0]==arr2[0]){
        	union.add(arr1[0]);
        	j++;
        	k++;
        }
        else{
        	union.add(arr1[0]);
        	j++;
        }
        for(int i=1;i<n+m;i++){
            if(j==n && k==m){
                break;
            }
            else if(j==n){
            	if(union.get(union.size()-1) != arr2[k])
                    union.add(arr2[k]);
                k++;
            }
            else if(k==m){
            	if(union.get(union.size()-1) != arr1[j])
                    union.add(arr1[j]);
                j++;
            }
            else if(arr1[j]<arr2[k]){
            	if(union.get(union.size()-1) != arr1[j])
                    union.add(arr1[j]);
                j++;
            }
            else if(arr1[j]==arr2[k]){
            	if(union.get(union.size()-1) != arr1[j])
                    union.add(arr1[j]);
                j++;
                k++;
            }
            else if(arr1[j]>arr2[k]){
            	if(union.get(union.size()-1) != arr2[k])
                    union.add(arr2[k]);
                k++;
            }
        }
        return union;
    }
}
