package corp.alv.challenges.general.strings.medium;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams01(List<String> words) {

        Map<String, List<String>> anagramsMap = new HashMap<>();

        words.forEach(word -> {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String newWord = new String(chars);

            if (anagramsMap.containsKey(newWord)) {
                anagramsMap.get(newWord).add(word);
            } else {
                anagramsMap.put(newWord, new ArrayList<String>(Arrays.asList(word)));
            }
        });


        return anagramsMap.values().stream().collect(Collectors.toList());
    }

}
