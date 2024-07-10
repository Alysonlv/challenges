package corp.alv.challenges;

public class Study {

    public static int[] solution(int[] a) {
        int[] w = new int[2];
        //50, 60, 60, 45, 70
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) {
                w[0] += a[i];
            } else {
                w[1] += a[i];
            }
        }

        return w;
    }

    public static void main(String[] args) {
        System.out.println(Study.solution(new int[]{50, 60, 60, 45, 70}));
    }
}
