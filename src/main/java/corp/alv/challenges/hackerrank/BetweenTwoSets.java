package corp.alv.challenges.hackerrank;

import java.util.List;

public class BetweenTwoSets {
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        boolean var, var2;
        int i;
        int j;
        int m = 0;
        for (i = a.get(a.size() - 1); i <= b.get(0); i++) {
            var = false;
            for (j = 0; j < a.size(); j++) {
                if (i % a.get(j) == 0) {
                    var = true;
                } else {
                    var = false;
                    break;
                }
            }
            if (var == true) {
                var2 = false;
                for (int k = 0; k < b.size(); k++) {
                    if (b.get(k) % i == 0) {
                        var2 = true;
                    } else {
                        var2 = false;
                        break;
                    }

                }
                if (var2 == true) {
                    m++;
                }
            }
        }
        return m;
    }
}
