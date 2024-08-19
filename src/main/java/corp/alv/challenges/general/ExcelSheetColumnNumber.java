package corp.alv.challenges.general;

import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...


Example 1:

Input: columnTitle = "A"
Output: 1
Example 2:

Input: columnTitle = "AB"
Output: 28
Example 3:

Input: columnTitle = "ZY"
Output: 701


Constraints:

1 <= columnTitle.length <= 7
columnTitle consists only of uppercase English letters.
columnTitle is in the range ["A", "FXSHRXW"].
 */
public class ExcelSheetColumnNumber {

    Map<String, Integer> columnMap = new HashMap<>();

    public int titleToNumber(String columnTitle) {
        if (columnMap.containsKey(columnTitle)) {
            return columnMap.get(columnTitle);
        }

        int index = 0;
        int power = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            char c = columnTitle.charAt(i);
            double pow = Math.pow(26, power);
            int individualCharIndex = (c - 'A' + 1);
            index += individualCharIndex * pow;
            power++;
        }

        columnMap.put(columnTitle, index);

        return index;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();
        System.out.println(excelSheetColumnNumber.titleToNumber("A"));
        System.out.println(excelSheetColumnNumber.titleToNumber("AB"));
        System.out.println(excelSheetColumnNumber.titleToNumber("ABC"));

    }
}
