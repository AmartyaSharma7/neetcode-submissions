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
    public ListNode reverseList(ListNode head) {
        ListNode p = null , q = head;
        if(q==null || q.next==null)return head;

        while(q!=null){
            ListNode temp = q.next;
            q.next = p;
            p=q;
            q=temp;
        }
        return p;
    }
}
