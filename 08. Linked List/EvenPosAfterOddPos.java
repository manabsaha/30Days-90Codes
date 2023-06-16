/* Given a singly linked list, the task is to rearrange it in a way that all odd position nodes are together and all even positions node are together.
Assume the first element to be at position 1 followed by second element at position 2 and so on.
Note: You should place all odd positioned nodes first and then the even positioned ones. (considering 1 based indexing). 
Also, the realtive order of odd positioned nodes and even positioned nodes shoud be maintained. */

class Solution
{
    void rearrangeEvenOdd(Node head)
    {
          if(head==null || head.next==null) return;
          Node odd = head;
          Node evenStart = head.next;
          Node even = head.next;
          while(even.next!=null && even.next.next!=null){
              odd.next = even.next;
              odd = even.next;
              even.next = odd.next;
              even = odd.next;
          }
          if(even.next!=null){
              odd.next = even.next;
              odd = even.next;
              even.next = null;
          }
          odd.next = evenStart;
     }
}
