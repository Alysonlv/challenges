package corp.alv.challenges.general.binarytrees.search.hard;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 
 *   An array of integers is said to represent the Binary Search Tree (BST)
 *   obtained by inserting each integer in the array, from left to right, into the
 *   BST.
 * 
 * 
 *   Write a function that takes in two arrays of integers and determines whether
 *   these arrays represent the same BST. Note that you're <i>not</i> allowed to
 *   construct any BSTs in your code.
 * 
 * 
 *   A BST is a Binary Tree that consists only of BST nodes. A node is said to be a
 *   valid BST node if and only if it satisfies the BST property: its value is
 *   strictly greater than the values of every node to its left; its value is less
 *   than or equal to the values of every node to its right; and its children nodes
 *   are either valid BST nodes themselves or None /
 *   null.
 * 
 * Sample Input
 * arrayOne = [10, 15, 8, 12, 94, 81, 5, 2, 11]
 * arrayTwo = [10, 8, 5, 15, 2, 12, 11, 94, 81]
 * 
 * Sample Output
 * true // both arrays represent the BST below
 *          10
 *        /     \
 *       8      15
 *     /       /   \
 *    5      12    94
 *  /       /     /
 * 2       11    81
 */
public class SameBSTs {

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        return areSameBSTs(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean areSameBSTs(List<Integer> arrayOne,
                                       List<Integer> arrayTwo,
                                       int rootIdxOne,
                                       int rootIdxTwo,
                                       int minVal,
                                       int maxVal) {

        if (rootIdxOne == -1 || rootIdxTwo == -1) {
            return rootIdxOne == rootIdxTwo;
        }

        if (arrayOne.get(rootIdxOne).intValue() != arrayTwo.get(rootIdxTwo).intValue()) {
            return false;
        }

        int leftRootIdxOne = getIdxOfFirstSmaller(arrayOne, rootIdxOne, minVal);
        int leftRootIdxTwo = getIdxOfFirstSmaller(arrayTwo, rootIdxTwo, minVal);
        int rightRootIdxOne = getIdxOfBiggerOrEqual(arrayOne, rootIdxOne, maxVal);
        int rightRootIdxTwo = getIdxOfBiggerOrEqual(arrayTwo, rootIdxTwo, maxVal);

        int currentValue = arrayOne.get(rootIdxOne);
        boolean leftAreSame = areSameBSTs(arrayOne, arrayTwo, leftRootIdxOne, leftRootIdxTwo, minVal, currentValue);
        boolean rightAreSame = areSameBSTs(arrayOne, arrayTwo, rightRootIdxOne, rightRootIdxTwo, currentValue, maxVal);

        return leftAreSame && rightAreSame;
    }

    private static int getIdxOfFirstSmaller(List<Integer> array, int startingIdx, int minVal) {
        for (int i = startingIdx + 1; i < array.size(); i++) {
            if (array.get(i).intValue() < array.get(startingIdx).intValue()
            && array.get(i).intValue() >= minVal) {
                return i;
            }
        }

        return -1;
    }

    private static int getIdxOfBiggerOrEqual(List<Integer> array, int startingIdx, int maxVal) {
        for (int i = startingIdx + 1; i < array.size(); i++) {
            if (array.get(i).intValue() >= array.get(startingIdx).intValue()
                    && array.get(i).intValue() < maxVal) {
                return i;
            }
        }

        return -1;
    }

    public static boolean sameBsts2(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.size() != arrayTwo.size()) {
            return false;
        }

        if (arrayOne.size() == 0 && arrayTwo.size() == 0) {
            return true;
        }

        if (arrayOne.get(0).intValue() != arrayTwo.get(0).intValue()) {
            return false;
        }

        List<Integer> leftSubtreeOne = getSmaller(arrayOne);
        List<Integer> leftSubtreeTwo = getSmaller(arrayTwo);
        List<Integer> rightSubtreeOne = getBiggerOrEqual(arrayOne);
        List<Integer> rightSubtreeTwo = getBiggerOrEqual(arrayTwo);

        return sameBsts(leftSubtreeOne, leftSubtreeTwo) && sameBsts(rightSubtreeOne, rightSubtreeTwo);
    }

    private static List<Integer> getSmaller(List<Integer> array) {
        List<Integer> smaller = new ArrayList<>();
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i).intValue() < array.get(0).intValue()) {
                smaller.add(array.get(i));
            }
        }

        return smaller;
    }

    private static List<Integer> getBiggerOrEqual(List<Integer> array) {
        List<Integer> biggerOrEqual = new ArrayList<>();
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i).intValue() >= array.get(0).intValue()) {
                biggerOrEqual.add(array.get(i));
            }
        }

        return biggerOrEqual;
    }

    public static void main(String[] args) {
        System.out.println(sameBsts(
                Arrays.asList(10,15,8,12,94,81,5,2,10),
                Arrays.asList(10,8,5,15,2,10,12,94,81)));
    }
}
