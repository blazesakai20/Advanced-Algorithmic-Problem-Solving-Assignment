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
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy, slow = dummy;

    // Move fast n+1 steps ahead to keep a gap of n between fast and slow
    for (int i = 0; i <= n; i++) {
        fast = fast.next;
    }

    // Move both until fast reaches the end
    while (fast != null) {
        fast = fast.next;
        slow = slow.next;
    }

    // Skip the target node
    slow.next = slow.next.next;

    return dummy.next;
    }
}