/* Some people(n) are standing in a queue. A selection process follows a rule where people standing on even positions are selected. 
Of the selected people a queue is formed and again out of these only people on even position are selected. This continues until we are left with one person. 
Find out the position of that person in the original queue. 
Explanation: 1,2,3,4,5,6,7,8,9  ->2,4,6,8  -> 4,8  -> 8. 
Time: O(logN) Space: O(1) 
Technique: Bit Manipulation -> Find the most significant set bit. */

class Solution {
    static long nthPosition(long n){
        // code here;
        int count = 0;
        while(n>0){
            count++;
            n = n>>1;
        }
        return (long)Math.pow(2,(count-1));
    }
}
