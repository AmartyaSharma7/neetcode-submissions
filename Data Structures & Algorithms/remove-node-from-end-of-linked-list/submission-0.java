/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode tail = head;
        if(head==null)return null;
        if(head.next == null && n==1)return null;

        while(tail!=null){
            tail=tail.next;
            length++;
        }
        
        int req = length - n;
        ListNode curr = head;
        ListNode prev = null;
        int start = 0;
        while(start<req){
            prev = curr;
            curr=curr.next;
            start++;
        }
        //curr points at the elementto be deleted ?
        if(prev==null)return curr.next;
        prev.next = curr.next;
        return head;
    }
}
