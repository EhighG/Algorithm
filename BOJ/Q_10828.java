package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q_10828 {

    static ArrayList<Integer> stack = new ArrayList(10);

    public static void main(String[] args) throws IOException {
        // 입력 복붙하면 하나 안나옴 --> 줄바꿈 안들어가서 버퍼에 남아있음.
        // 이 방식이 시간 더 들지만, 더 낫다!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        String instruction;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            instruction = st.nextToken();
            switch (instruction) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "top":
                    sb.append(top()).append("\n");
                    break;
            }
        }
//        bw.write(String.valueOf(sb));
//        bw.close();
        System.out.println(sb);



    }
    static void push(int val) {stack.add(val);}

    static int pop() {
        int idx = stack.size()-1;
        int result = (idx == -1) ? -1 : stack.remove(idx);
        return result;
    }

    static int empty() {
        return stack.isEmpty()? 1 : 0;
    }

    static int size() {
        return stack.size();
    }

    static int top() {
        return (stack.isEmpty())? -1 : stack.get(stack.size()-1);
    }

}