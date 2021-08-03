/* LEETCODE 2: ADD TWO NUMBERS
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes 
contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807 **/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int sum = 0;
        int carry = 0;
        while(true){
            sum = 0;
            if(l1==null && l2==null && carry==0){
                break;
            }
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            sum+=carry;
            carry = sum / 10;
            temp.next = new ListNode(sum%10);
            temp = temp.next;
        }
        return dummy.next;
    }
}
