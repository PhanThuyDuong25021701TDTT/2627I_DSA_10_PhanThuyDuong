package Week_03;
// Bài tập về nhà
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class Solution {
    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty() || stack.peek() != pairs.get(c)) {
                    return "NO";
                }
                stack.pop();
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }
}
