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
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    ListNode sort(ListNode p, ListNode q) {
        if (p == null || p == q) {
            return p;
        }
        boolean sorted = true;
        ListNode curr = p;
        while (curr.next != null && curr != q) {
            if (curr.val > curr.next.val) {
                sorted = false;
                break;
            }
            curr = curr.next;
        }
        if (sorted) {
            return p;
        }
        ListNode pre = p;
        ListNode head = p;
        curr = pre.next;
        while (curr != null && curr != q) {
            ListNode next = curr.next;
            if (curr.val < p.val) {
                pre.next = next;
                curr.next = head;
                head = curr;
            } else {
                pre = curr;
            }
            curr = next;
        }
        p.next = sort(p.next, q);
        return sort(head, p);
    }
}