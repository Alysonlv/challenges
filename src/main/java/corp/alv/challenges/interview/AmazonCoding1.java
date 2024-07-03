package corp.alv.challenges.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AmazonCoding1 {

    public static List<Integer> getTotalRequests(List<Integer> server, List<Integer> replaceId, List<Integer> newId) {
        List<Integer> totalRequests = new ArrayList<>();

        for (int i = 0; i < replaceId.size(); i++) {
            int replaceValue = replaceId.get(i);
            int newValue = newId.get(i);

            for (int j = 0; j < server.size(); j++) {
                if (server.get(j) == replaceValue) {
                    server.set(j, newValue);
                }
            }

            int sum = 0;
            for (int value : server) {
                sum += value;
            }
            totalRequests.add(sum);
        }

        return totalRequests;

    }

    public static void main(String[] args) {
        AmazonCoding1 a = new AmazonCoding1();
        List<Integer> r = AmazonCoding1.getTotalRequests(
                Arrays.asList(20, 10),
                Arrays.asList(10, 20),
                Arrays.asList(20, 1)
        );
        System.out.println(r);
    }
}
