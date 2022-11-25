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
//        TreeNode left = new TreeNode();
//        left.val = 1;
//        TreeNode right = new TreeNode();
//        right.val = 3;
//        TreeNode middle = new TreeNode(2, left, right);
//
//        inorderTraversal(left);


        //////Trees ----???


//---------118. Pascal's Triangle
//        generate(5);


//--------121. Best Time to Buy and Sell Stock
//        int[] prices = {7, 1, 5, 3, 6, 4};
//        System.out.println(maxProfit(prices));
//
//        int[] prices2 = {7, 6, 4, 3, 1};
//        System.out.println(maxProfit(prices2));

//        int[] prices3 = {7, 2, 10, 3, 1, 6, 4};
//        System.out.println(maxProfit(prices3));
//
//        int[] singleNumbers = {2, 2, 1};
//        System.out.println(singleNumber(singleNumbers));

//--------141. Linked List Cycle


//        160. Intersection of Two Linked Lists


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

    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

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

    //104. Maximum Depth of Binary Tree
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }

    //108. Convert Sorted Array to Binary Search Tree
    int[] nums;

    public TreeNode recurssionBST(int left, int right) {
        if (left > right) return null;

        int temp = (left + right) / 2;

        TreeNode root = new TreeNode(nums[temp]);

        root.left = recurssionBST(left, temp - 1);
        root.right = recurssionBST(temp + 1, right);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return recurssionBST(0, nums.length - 1);
    }

    //118. Pascal's Triangle
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> currRow = new ArrayList<>();
            List<Integer> prevRow = triangle.get(i - 1);

            //first element
            currRow.add(1);
            for (int j = 1; j < i; j++) {
                currRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            //last element
            currRow.add(1);
            triangle.add(currRow);
        }
        return triangle;
    }

    //121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int minprice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }

        return maxprofit;
    }

    //136. Single Number
    public int singleNumber(int[] nums) {
        List<Integer> no_duplicate_list = new ArrayList<>();

        for (int i : nums) {
            if (!no_duplicate_list.contains(i)) {
                no_duplicate_list.add(i);
            } else {
                no_duplicate_list.remove(Integer.valueOf(i));
            }
        }
        return no_duplicate_list.get(0);
    }

    //141. Linked List Cycle
    public boolean hasCycle(ListNode head) {
        Set<Integer> nodes = new HashSet<>();

        while (head != null) {
            if (nodes.contains(head.val)) {
                return true;
            }
            nodes.add(head.val);
            head = head.next;
        }
        return false;
    }

    //141. Linked List Cycle _ solutions by two pointers -don't understand
    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    //    160
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA :nodeB.next;
        }
        return nodeA;
    }

}

