/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val; ListNode next;
 * ListNode(int x) {
 * val = x; next = null;}}
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode temp = head;
        if (temp == null) {
            return false;
        }
        HashSet<ListNode> set = new HashSet<>();
        while (!set.contains(temp)) {
            set.add(temp);
            temp = temp.next;
            if (temp == null) {
                return false;
            }
        }
        if (temp.next != null && temp.next.next != null && set.contains(temp.next) && set.contains(temp.next.next)) {
            return true;
        }
        return false;
    }
}