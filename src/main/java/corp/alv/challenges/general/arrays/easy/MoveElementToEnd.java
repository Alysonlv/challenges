package corp.alv.challenges.general.arrays.easy;

import java.util.List;

/*
 * you're give an array of integer and one integer. write a function that move all instances of that integer
 * to the end of the array and return it
 */
public class MoveElementToEnd {

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int left = 0;
        int right = array.size() - 1;

        while (left < right) {
            while (left < right && array.get(right) == toMove) {
                right--;
            }
            if (array.get(left) == toMove) {
                swap(left, right, array);
            }
            left++;
        }

        return array;
    }

    public static List<Integer> moveElementToEnd2(List<Integer> array, int toMove) {
        int left = 0;
        int right = array.size() - 1;

        while (left < right) {
            if (array.get(right) == toMove) {
                right--;
                continue;
            }
            if (array.get(left) == toMove) {
                swap(left, right, array);
            }
            left++;
        }

        return array;
    }

    private static void swap(int left, int right, List<Integer> array) {
        int temp = array.get(right);
        array.set(right, array.get(left));
        array.set(left, temp);
    }
}
