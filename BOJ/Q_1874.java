package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q_1874 {

    static List<Integer> stack = new LinkedList<>();
    static int top = 0;
    static int cur = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int num;
        while (n-- > 0) {
            num = Integer.parseInt(br.readLine());

            if (num < top) {
                System.out.println("NO");
                return;
            }
            if (num >= cur) sb.append(push(num - cur + 1));
            sb.append(pop());
        }
        System.out.println(sb);
    }

    private static String push(int gap) {
        String ret = "+\n".repeat(gap);
        while (gap-- > 0) {
            stack.add(cur++);
        }
        top = cur - 1;

        return ret;
    }

    private static String pop() {
        int length = stack.size();
        stack.remove(--length);
        top = (length != 0) ? stack.get(--length) : 0;
        return "-\n";
    }
}
