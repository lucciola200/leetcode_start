package LinkedListsProblems;

import java.util.LinkedList;

import LeetCodeData.ListNode;

public class LinkedLists {
    public static void main(String[] args) {
        // 2.Add Two Numbers
//        addTwoNumbersRunner();

        // 21. Merge Two Sorted Lists
//        mergeTwoSortedListsRunner();

        // 83. Remove Duplicates from Sorted List
//        removeDuplicatesfromSortedListRunner();

        // 1290. Convert Binary Number in a Linked List to Integer
//        getDecimalValueRunner(); ??

        // 23. Merge k Sorted Lists
//        mergeKListsRunner();
        // 24. Swap Nodes in Pairs
        swapPairsRunner();
    }

    public static void printLL(ListNode answer) {
        while (answer != null) {
            System.out.print(answer.val + " ");
            answer = answer.next;
        }
    }

    public static void addTwoNumbersRunner() {
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(3);

        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(4);
        ListNode answer = addTwoNumbers(list1, list2);
        printLL(answer);
    }

    public static void mergeTwoSortedListsRunner() {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode answer = mergeTwoLists(listNode1, listNode2);
        printLL(answer);
    }

    public static void removeDuplicatesfromSortedListRunner() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(2);
        printLL(deleteDuplicates(listNode));
    }

    public static void getDecimalValueRunner() {

    }

    public static void mergeKListsRunner() {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode answer = mergeKLists(new ListNode[]{list1, list2, list3});
        printLL(answer);
    }

    public static void swapPairsRunner() {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
//        list1.next.next.next = new ListNode(4);
//        list1.next.next.next.next = new ListNode(5);
//        list1.next.next.next.next.next = new ListNode(6);

        printLL(swapPairs(list1));

    }


    /*--2. Add Two Numbers
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order, and each of their nodes contains a single digit.
    Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listHead = new ListNode(0);
        ListNode listTail = listHead;
        int fractionalPart = 0;
        int digit = 0;
        int digit1 = 0;
        int digit2 = 0;

        int sum = 0;

        while (l1 != null || l2 != null || fractionalPart != 0) {
            digit1 = l1 != null ? l1.val : 0;
            digit2 = l2 != null ? l2.val : 0;

            sum = digit1 + digit2 + fractionalPart;
            digit = sum % 10;
            fractionalPart = sum / 10;

            ListNode newNode = new ListNode(digit);
            listTail.next = newNode;
            listTail = listTail.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        ListNode result = listHead.next;
        listHead.next = null;
        return result;
    }


    /* -- 21. Merge Two Sorted Lists
    You are given the heads of two sorted linked lists list1 and list2.
    Merge the two lists into one sorted list.
    The list should be made by splicing together the nodes of the first two lists.
    Return the head of the merged linked list.
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode result = new ListNode(0);
        ListNode cur = result;

        while (true) {
            if (list1 == null && list2 == null) {
                return result.next;
            } else if (list1 == null) {
                cur.next = list2;
                return result.next;
            } else if (list2 == null) {
                cur.next = list1;
                return result.next;
            } else {
                if (list1.val < list2.val) {
                    cur.next = list1;
                    cur = list1;
                    list1 = list1.next;

                } else {
                    cur.next = list2;
                    cur = list2;
                    list2 = list2.next;
                }
            }
        }
    }

    /* 83
    Given the head of a sorted linked list, delete all duplicates such
    that each element appears only once. Return the linked list sorted as well.
     */
    public static ListNode deleteDuplicates(ListNode head) {

        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    /*
    Given head which is a reference node to a singly-linked list.
    The value of each node in the linked list is either 0 or 1.
    The linked list holds the binary representation of a number.

    Return the decimal value of the number in the linked list.
    The most significant bit is at the head of the linked list.
     */

    public static int getDecimalValue(ListNode head) {
        return 0;
    }

    /*23. Merge k Sorted Lists
    You are given an array of k linked-lists lists,
    each linked-list is sorted in ascending order.
    Merge all the linked-lists into one sorted linked-list and return it.
     */
    public static ListNode mergeKLists(ListNode[] lists) {

        int k = lists.length;
        int n = 1;

        while (n < k) {
            int range = k - n;
            int step = n * 2;
            for (int i = 0; i < range; i += step) {
                lists[i] = mergeTwoListsForKList(lists[i], lists[i + n]);
            }
            n *= 2;
        }
        return k > 0 ? lists[0] : null;

    }

    public static ListNode mergeTwoListsForKList(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cur = result;

        while (true) {
            if (l1 == null && l2 == null) {
                return result.next;
            }
            if (l1 == null) {
                cur.next = l2;
                return result.next;
            } else if (l2 == null) {
                cur.next = l1;
                return result.next;
            } else {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    cur = cur.next;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    cur = cur.next;
                    l2 = l2.next;
                }
            }
        }
    }

    /*
    24. Swap Nodes in Pairs
    Given a linked list, swap every two adjacent nodes and return its head.
    You must solve the problem without modifying the values
    in the list's nodes (i.e., only nodes themselves may be changed.)
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode curr = result;

        while (head != null && head.next != null) {

            ListNode first = head;
            ListNode second = head.next;

            curr.next = second;
            first.next = second.next;
            second.next = first;

            curr = first;
            head = first.next;
        }
        return result.next;
    }

}
