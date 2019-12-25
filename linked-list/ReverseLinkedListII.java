
// LC-92
// https://leetcode.com/problems/reverse-linked-list-ii/

public class ReverseLinkedListII {

  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    for (int i = 0; i < m - 1; i++) {
      prev = prev.next;
    }

    ListNode start = prev.next;
    ListNode then = start.next;

    for (int i = 0; i < n - m; i++) {
      start.next = then.next;
      then.next = prev.next;
      prev.next = then;
      then = start.next;
    }

    return dummy.next;
  }
}
