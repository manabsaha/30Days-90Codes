/* Given a singly linked list of size N of integers. The task is to check if the given linked list is palindrome or not.
Input:
N = 3
value[] = {1,2,1}
Output: 1
Explanation: The given linked list is
1 2 1 , which is a palindrome and
Hence, the output is 1. */

class Solution
{
    boolean isPalindrome(Node head) 
    {
        if(head==null) return false;
        if(head.next==null) return true;
        Node fast = head;
        Node slow = head;
        //find mid
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //reverse after mid
        slow.next = reverse(slow.next);
        //compare two halves
        slow = slow.next;
        Node dummy = head;
        while(slow!=null){
            if(dummy.data != slow.data) return false;
            dummy = dummy.next;
            slow = slow.next;
        }
        return true;
    }  
    private Node reverse(Node head){
        Node rev = head;
        head = head.next;
        rev.next = null;
        Node nextNode = null;
        while(head!=null){
            nextNode = head.next;
            head.next = rev;
            rev = head;
            head = nextNode;
        }
        return rev;
    }
}
