/* Given two sorted linked lists consisting of N and M nodes respectively. 
The task is to merge both of the list (in-place) and return head of the merged list. 
valueN[] = {5,10,15,40}
valueM[] = {2,3,20}
Output: 2 3 5 10 15 20 40 */

class LinkedList
{
    Node sortedMerge(Node head1, Node head2) {
        Node p1 = head1;
        Node p2 = head2;
        Node dummy = new Node(0);
        Node temp = dummy;
        while(true){
            if(p1==null && p2==null){
                break;
            }
            else if(p1==null){
                temp.next = p2;
                p2 = p2.next;
            }
            else if(p2==null){
                temp.next = p1;
                p1 = p1.next;
            }
            else if(p1.data<p2.data){
                temp.next = p1;
                p1 = p1.next;
            }
            else{
                temp.next = p2;
                p2 = p2.next;
            }
            temp = temp.next;
        }
        return dummy.next;
   } 
}
