package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q_10845 {

    static ArrayList<Integer> queue = new ArrayList<>(10);
    
    public static void main(String[] args) throws IOException {
        // 큐
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String instruction;

        while(N-- > 0) {
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
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    static void push(int num) { queue.add(num); }

    static int pop() { return (queue.size() == 0) ? -1 : queue.remove(0); }

    static int size() { return queue.size(); }

    static int empty() { return (queue.isEmpty()) ? 1 : 0; }

    static int front() { return (queue.isEmpty()) ? -1 : queue.get(0); }

    static int back() { return (queue.isEmpty()) ? -1 : queue.get(queue.size()-1); }
}