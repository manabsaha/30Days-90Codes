/*Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.
Input: 
Linked List 1 = 4->1->common
Linked List 2 = 5->6->1->common
common = 8->4->5->NULL
Output: 8 */

//Approach 1: Make cycle in list1 in traverse list 2 for list1 head.
//Approach 2: Store addresses of last node and check if they are same
//Approach 3: Use difference of lists to find the starting point.

class Solution
{
	int intersectPoint(Node head1, Node head2)
	{
	    int count1=0,count2=0;
	    Node temp1 = head1;
	    Node temp2 = head2;
	    while(temp1!=null){
	        count1++;
	        temp1=temp1.next;
	    }
	    while(temp2!=null){
	        count2++;
	        temp2=temp2.next;
	    }
	    int d;
	    temp1 = head1;
	    temp2 = head2;
	    if(count1>count2){
	        d = count1-count2;
	        while(d-- != 0){
	            temp1=temp1.next;
	        }
	    }
	    else{
	        d = count2-count1;
	        while(d-- != 0){
	            temp2=temp2.next;
	        }
	    }
	    while(temp1.next!=null){
	        if(temp1.next == temp2.next){
	            //intersection point found
	            return temp1.next.data;
	        }
	        temp1 = temp1.next;
	        temp2 = temp2.next;
	    }
	    return -1;
	}
}
