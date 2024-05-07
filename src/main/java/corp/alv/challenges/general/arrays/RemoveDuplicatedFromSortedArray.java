package corp.alv.challenges.general.arrays;

public class RemoveDuplicatedFromSortedArray {

    public int removeDuplicates(int[] arr) {
        int index = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[index] = arr[i];
                index++;
            }
        }
// 1 2 2 3
        return index;
    }

    public static void main(String[] args) {
        RemoveDuplicatedFromSortedArray rm = new RemoveDuplicatedFromSortedArray();
        int[] arr = {0,0,1,1,1,2,2,3,3,4};

        System.out.println(rm.removeDuplicates(arr));
    }
}
