package November2023;

import org.codehaus.groovy.runtime.typehandling.BigIntegerMath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCodeTop100LikedQuestions {
    public static void main(String[] args) {
// -------1. Two Sum
//        int[] numAr = {2, 7, 11, 15};
//        int target1 = 9;
//        int[] solution = twoSum(numAr, target1);
//        System.out.println(Arrays.toString(solution));

        System.out.println(generateParenthesis(3));

    }

    //1. Two Sum
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int curr;
        for (int i = 0; i < nums.length; i++) {
            curr = nums[i];
            int x = target - nums[i];
            if (map.containsKey(x)) {
                return new int[]{map.get(x), i};
            } else
                map.put(nums[i], i);
        }
        return null;
    }

    /*   22. Generate Parentheses
        Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
        Input: n = 3
        Output: ["((()))","(()())","(())()","()(())","()()()"]
     */
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        recurse(res, 0, 0, "", n);
        return res;
    }

    public static void recurse(List<String> res, int left, int right, String s, int n) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }

        if (left < n) {
            recurse(res, left + 1, right, s + "(", n);
        }

        if (right < left) {
            recurse(res, left, right + 1, s + ")", n);
        }
    }

//    public static List<String> generateParenthesis(int n) {
//        //Approach: using Backtracking
//        List<String> ans = new ArrayList<>();
//        backtrack("", n, n, ans);
//        return ans;
//    }
//    public static void backtrack(String s, int open, int close, List<String> ans){
//        //base case
//        if(open>close) return;
//        if(open>0){
//            backtrack(s+"(", open-1, close, ans);
//        }
//        if(close>0){
//            backtrack(s+")", open, close-1, ans);
//        }
//        if(open==0 && close==0){
//            ans.add(s);
//        }
//    }
}
