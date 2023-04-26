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
    ListNode findMiddle(ListNode head) {
        ListNode t = head;
        ListNode h = head;

        if (h.next != null && h.next.next != null) {
            h = h.next.next;
            t = t.next;
        }
        return t;
    }

    ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;

    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;


        ListNode middle = findMiddle(head);
        ListNode second = reverse(middle.next);

        ListNode start = head;
        while (second != null && start != null) {
            if (start.val != second.val) return false;
            start = start.next;
            second = second.next;
        }
        return true;
    }
}