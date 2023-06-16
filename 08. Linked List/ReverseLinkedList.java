/* Given a linked list of N nodes. The task is to reverse this list.
Input: 1->2->3->4->5->6
Output: 6->5->4->3->2->1 */

/* linked list node class:

class Node {
    int value;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

*/

class Solution{
    Node reverseList(Node head){
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
