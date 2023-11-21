import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AlgoExpertEasy {
    public static void main(String[] args) {
        //1 Two Number Sum
        int[] arr = {3, 5, -4, 8, 11, 1, -1, 6};
        int[] test = twoNumberSum(arr, 10);

        //2 Validate Subsequence
        List<Integer> arr1 = List.of(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> arr2 = List.of(1, 6, -1, 10);
        boolean resp1 = isValidSubsequence(arr1, arr2);

        //3 Sorted Squared Array
        int[] arr3 = {-5, -4, -3, -2, -1};
        int[] test3 = sortedSquaredArray(arr3);
        Arrays.stream(test3).forEach(System.out::println);
    }

    //1 Two Number Sum
    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        HashMap<Integer, Integer> mapArr = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            int temp = targetSum - array[i];
            if (mapArr.containsKey(temp)) {
                int[] returnArr = {array[i], temp};
                return returnArr;
            } else {
                mapArr.put(array[i], i);
            }
        }

        return new int[0];
    }

    //2 Validate Subsequence
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        int arrayPointer = 0;
        int sequencePointer = 0;

        while (arrayPointer < array.size() && sequencePointer < sequence.size()) {
            if (array.get(arrayPointer) == sequence.get(sequencePointer)) {
                sequencePointer++;
            }
            arrayPointer++;
        }

        return sequencePointer == sequence.size();
    }

    //3 Sorted Squared Array
    public static int[] sortedSquaredArray(int[] array) {
        // Write your code here.
        int n = array.length;
        int[] returnArr = new int[n];
        int left = 0;
        int right = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            int square;
            if (Math.abs(array[left]) < Math.abs(array[right])) {
                square = array[right];
                right--;
            } else {
                square = array[left];
                left++;
            }
            returnArr[i] = square * square;
        }
        return returnArr;
    }
}
