/* Given a binary string S. The task is to count the number of substrings that start and end with 1. For example, if the input string is “00100101”, 
then there are three substrings “1001”, “100101” and “101”. 
Time: O(n) Space: O(1)
This is problem of combination. Total combinations = N(C)2 */

class Solution
{
    public static int binarySubstring(int n, String str)
    {
        int count = 0;
        for(int i=0;i<n;i++){
            if(str.charAt(i)=='1') count++;
        }
        return (count*(count-1))/2;
    }
}
