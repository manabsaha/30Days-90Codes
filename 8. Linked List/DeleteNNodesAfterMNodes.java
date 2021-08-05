/* Given a linked list, delete N nodes after skipping M nodes of a linked list until the last of the linked list.
Eg. 
2 1
9 1 3 5 9 4 10 1
Output: 9 1 5 9 10 1 */

class Solution
{
    static void linkdelete(Node head, int M, int N)
    {
       int count = 0;
       int n;
       while(head!=null && head.next!=null){
           count++;
           if(count==M){
               count = 0;
               n = N;
               Node temp = head;
               while(n-- != 0 && temp.next!=null){
                   temp = temp.next;
               }
               head.next = temp.next;
               head = head.next;
           }
           else{
                head = head.next;   
           }
       }
    }
}
