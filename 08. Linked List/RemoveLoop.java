/* Given a linked list of N nodes such that it may contain a loop.
A loop here means that the last node of the link list is connected to the node at position X. If the link list does not have any loop, X=0.
Remove the loop from the linked list, if it is present. */

class Solution
{
    public void removeLoop(Node head){
        if(head==null || head.next==null) return;
        Node slow = head;
        Node fast = head;
        while(fast.next !=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) break;
        }
        if(slow==fast){
            fast = head;
            if(slow!=fast){
                while(fast.next!=slow.next){
                    fast=fast.next;
                    slow=slow.next;
                }
                slow.next = null;
            }
            //if fast and slow at first node.
            else{
                while(slow.next!=fast){
                    slow = slow.next;
                }
                slow.next = null;
            }
        }
    }
}
