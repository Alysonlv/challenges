package corp.alv.challenges.interview;


import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String... args) {
        List<String> tst = new ArrayList<>();

        tst.add("aa");
        tst.add("aa");
        tst.add("aa");

        List<Integer> tst2 = new ArrayList<>();
        tst2.add(1);
        tst2.add(1);
        tst2.add(10);
        tst2.add(13);

        System.out.println(tst2.stream().min(Integer::compareTo).get());
    }

}
