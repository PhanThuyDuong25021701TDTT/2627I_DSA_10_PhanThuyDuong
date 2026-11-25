package Week_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingNumberSort {
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        Collections.sort(arr);
        Collections.sort(brr);

        List<Integer> result = new ArrayList<>();
        int i = 0; // Con trỏ cho arr
        int j = 0; // Con trỏ cho brr

        while (j < brr.size()) {
            if (i < arr.size() && arr.get(i).equals(brr.get(j))) {
                i++;
                j++;
            } else {
                int missing = brr.get(j);
                // Tránh thêm trùng lặp nếu một số thiếu nhiều lần
                if (result.isEmpty() || result.get(result.size() - 1) != missing) {
                    result.add(missing);
                }
                j++;
            }
        }
        return result;
    }
}
