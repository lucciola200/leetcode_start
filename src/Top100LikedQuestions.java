import java.util.*;

public class Top100LikedQuestions {
    public void runSolutions() {
// -------1. Two Sum
//        int[] numAr = {2, 7, 11, 15};
//        int target1 = 9;
//        int[] solution = twoSum(numAr, target1);
//        System.out.println(Arrays.toString(solution));
//
//        int[] numAr2 = {2, 3, 4};
//        int target2 = 6;
//        int[] solution2 = twoSum(numAr2, target2);
//        System.out.println(Arrays.toString(solution2));

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
//--------smt like Fibonacci
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        System.out.println(climbStairs(n));

//--------94. Binary Tree Inorder Traversal
        TreeNode left = new TreeNode();
        left.val = 1;
        TreeNode right = new TreeNode();
        right.val = 3;
        TreeNode middle = new TreeNode(2, left, right);

        inorderTraversal(left);

    }

    //1. Two Sum
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int x = target - curr;
            if (map.containsKey(x)) {
                return new int[]{map.get(x), i};
            }
            map.put(curr, i);
        }
        return null;
    }

    //20. Valid Parentheses
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();
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

    //21. Merge Two Sorted Lists
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

    //35. Search Insert Position
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

    //70. Climbing Stairs
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


    //94. Binary Tree Inorder Traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    //101. Symmetric Tree _ recursion
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;

        return (left.val == right.val)
                && isMirror(left.right, right.left)
                && isMirror(left.left, right.right);
    }

    //101. Symmetric Tree _ Iterative
    public boolean isSymmetric2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;
            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);
        }
        return true;
    }


}
