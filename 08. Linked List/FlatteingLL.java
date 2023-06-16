/* Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 
Note: The flattened list will be printed using the bottom pointer instead of next pointer. */

class GfG
{
    Node flatten(Node root)
    {
	    Node t1 = root;
	    Node t2 = root.next;
	    if(t1==null){
	        return null;
	    }
	    if(t2==null){
	        return root;
	    }
	    Node curr = t2.next;
	    t1.next = null;
	    t2.next = null;
	    Node head = merge(t1,t2);
	    while(curr!=null){
	        t2 = curr;
	        curr = curr.next;
	        t2.next = null;
	        head = merge(head,t2);
	    }
	    return head;
    }
    
    Node merge(Node head1, Node head2) {
        Node p1 = head1;
        Node p2 = head2;
        Node dummy = new Node(0);
        Node temp = dummy;
        while(true){
            if(p1==null && p2==null){
                break;
            }
            else if(p1==null){
                temp.bottom = p2;
                p2 = p2.bottom;
            }
            else if(p2==null){
                temp.bottom = p1;
                p1 = p1.bottom;
            }
            else if(p1.data<p2.data){
                temp.bottom = p1;
                p1 = p1.bottom;
            }
            else{
                temp.bottom = p2;
                p2 = p2.bottom;
            }
            temp = temp.bottom;
        }
        return dummy.bottom;
   }
}
