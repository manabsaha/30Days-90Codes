/*Given a singly linked list of size N. The task is to rotate the linked list counter-clockwise by k nodes, where k is a given positive integer 
smaller than or equal to length of the linked list.
Input:
N = 5
value[] = {2, 4, 7, 8, 9}
k = 3
Output: 8 9 [2 4 7] */

class Solution{
    public Node rotate(Node head, int k) {
        Node temp = head;
        int count = 1;
        while(temp.next!=null){
            temp = temp.next;
            count++;
        }
        if(k==0 || k==count) return head;
        temp = head;
        while(--k != 0){
            temp = temp.next;
        }
        Node temp2 = temp.next;
        temp.next = null;
        Node temp3 = temp2;
        while(temp3.next != null){
            temp3 = temp3.next;
        }
        temp3.next = head;
        head = temp2;
        return head;
    }
}
