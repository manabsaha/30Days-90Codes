/* Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list. If the number 
of nodes is not a multiple of k then left-out nodes, in the end, should be considered as a group and must be reversed  
Approach:
1) call reverse on head by separating from nexthead. 
2) add reverse to result 
3) call reverse on nexthead and continue.
*/

class Solution
{
    public static Node reverse(Node node, int k)
    {
        int cnt;
        Node head = node;
        Node nexthead = head;
        Node res = null;
        
        //reverse in group
        while(nexthead!=null){
            nexthead = head;
            cnt = k-1;
            while(cnt--!=0){
                if(nexthead.next==null){
                    break;
                }
                nexthead = nexthead.next;
            }
          
            // call reverse on head. 
            // add to result
            // call reverse on nexthead.
            Node temp = nexthead.next;
            nexthead.next = null;
            nexthead = temp;
            temp = reverse(head);
            
            //store to result list
            if(res!=null){
                Node t = res;
                while(t.next!=null){
                    t = t.next;
                }
                t.next = temp;
            }
            else{
                res = temp;
            }
            head = nexthead;
        }
        return res;
    }
    
    static Node reverse(Node head){
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
