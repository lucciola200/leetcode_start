import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Top100LikedQuestions {
    public void runSolutions() {

// -------20. Valid Parentheses
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//
//        System.out.println(isValid(s));

//--------21. Merge Two Sorted Lists
//        ListNode list1 = new ListNode(1);
//        list1.next = new ListNode(2);
//        list1.next.next = new ListNode(4);
//
//        ListNode list2 = new ListNode(1);
//        list2.next = new ListNode(3);
//        list2.next.next = new ListNode(4);
//        System.out.println(mergeTwoLists(list1, list2));

//--------35. Search Insert Position
//        int[] nums = {1, 3, 5, 6};
//        int target = 5;
//        System.out.println(searchInsert(nums, target));
//
//        int target2 = 2;
//        System.out.println(searchInsert(nums, target2));
//
//        int target3 = 7;
//        System.out.println(searchInsert(nums, target3));

//--------70. Climbing Stairs
//------------*smt like Fibonacci
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(climbStairs(n));
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();
        for (Character ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character lastChar = stack.pop();
                if (map.get(lastChar) != ch) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 == null ? list2 : list1;

        return preHead.next;
    }

    public int searchInsert(int[] nums, int target) {
        int middle, left = 0, right = nums.length - 1;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (target == nums[middle]) {
                return middle;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else left = middle + 1;
        }
        return left;
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        int third;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
