package Week_03;
import java.util.Scanner;
public class w3_tailop_25021701 {
    public static int doUuTien(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap bieu thuc trung to: ");
        String a = sc.nextLine();
        String s = "";
        Stack<Character> stack = new Stack<Character>();
        int i = 0;
        while (i < a.length()) {
            char c = a.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }
            if (Character.isDigit(c)) {
                String so = "";
                while (i < a.length() && Character.isDigit(a.charAt(i))) {
                    so = so + a.charAt(i);
                    i++;
                }
                s = s + so + " ";
                continue;
            }
            if (c == '(') {
                stack.push(c);
                i++;
                continue;
            }
            if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    s = s + stack.pop() + " ";
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                i++;
                continue;
            }
            while (!stack.isEmpty() && stack.peek() != '(' && doUuTien(stack.peek()) >= doUuTien(c)) {
                s = s + stack.pop() + " ";
            }
            stack.push(c);
            i++;
        }
        while (!stack.isEmpty()) {
            s = s + stack.pop() + " ";
        }
        System.out.println("Bieu thuc trung to: " + a);
        System.out.println("Bieu thuc hau to: " + s.trim());
    }
}