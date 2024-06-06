/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
 public class SumOfNumbersLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2,0);
    }

    public ListNode add(ListNode n1, ListNode n2, int reminder) {
        ListNode nonNullNode=null;
        if (n1 == null && n2 == null && reminder ==0) {
            return null;
        } else if (n1 == null && n2 == null) {
            return new ListNode(reminder, null);
        } else if(n1 == null) {
            nonNullNode = n2;
        } else if (n2 == null) {
            nonNullNode = n1;
        } else {
            int sum = n1.val + n2.val + reminder;
            int rem = sum / 10;
            ListNode result = add(n1.next, n2.next, rem);
            return new ListNode(sum%10, result);
        }
        int sum = reminder + nonNullNode.val;
        int rem = sum /10;
        ListNode result = add(nonNullNode.next, null, rem);
        return new ListNode(sum%10, result);
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}