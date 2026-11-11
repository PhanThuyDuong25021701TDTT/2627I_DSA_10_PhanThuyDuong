package Week_07;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> result = new ArrayList<>();

        // Max-heap chứa nửa phần tử nhỏ hơn
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // Min-heap chứa nửa phần tử lớn hơn
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : a) {
            // Thêm vào maxHeap trước
            maxHeap.add(num);

            // Đẩy phần tử lớn nhất của maxHeap sang minHeap để giữ thứ tự
            minHeap.add(maxHeap.poll());

            // Cân bằng số lượng phần tử giữa 2 heap
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }

            // Tính median dựa trên đỉnh của heap
            if (maxHeap.size() > minHeap.size()) {
                result.add((double) maxHeap.peek());
            } else {
                result.add((maxHeap.peek() + minHeap.peek()) / 2.0);
            }
        }

        return result;
    }

}
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
