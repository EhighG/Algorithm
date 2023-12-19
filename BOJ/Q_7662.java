package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_7662 {

    static PriorityQueue<Integer> minQ = new PriorityQueue<>();
    static PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
    static Map<Integer, Integer> cnts = new HashMap<>();
    static Set<Integer> exists = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            minQ.clear();
            maxQ.clear();
            cnts.clear();
            exists.clear();
            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String oper = st.nextToken();
                int val = Integer.parseInt(st.nextToken());

                if (oper.equals("I")) {
                    maxQ.offer(val);
                    minQ.offer(val);
                    Integer curCnt = cnts.get(val);
                    cnts.put(val, (curCnt != null) ? curCnt+1 : 1);
                    exists.add(val);
                    continue;
                }
                // pop
                if (val < 0) { // minQ
                    while (!minQ.isEmpty()) {
                        int deleted = minQ.poll();
                        if (!exists.contains(deleted)) continue;
                        int cnt = cnts.get(deleted);
                        if (cnt == 1) exists.remove(deleted);
                        cnts.put(deleted, cnt-1);
                        break;
                    }
                    continue;
                }
                while (!maxQ.isEmpty()) {
                    int deleted = maxQ.poll();
                    if (!exists.contains(deleted)) continue;
                    int cnt = cnts.get(deleted);
                    if (cnt == 1) exists.remove(deleted);
                    cnts.put(deleted, cnt-1);
                    break;
                }
            }
            // delete되지 않은 값은, 양쪽 큐 모두에 남아있어야 한다.
            int min = Integer.MAX_VALUE;
            boolean valid = false;
            while (!minQ.isEmpty()) {
                int cur = minQ.poll();
                if (!exists.contains(cur)) continue;
                if (cur < min) min = cur;
                valid = true;
            }
            if (!valid) {
                sb.append("EMPTY\n");
                continue;
            }
            int max = Integer.MIN_VALUE;
            while (!maxQ.isEmpty()) {
                int cur = maxQ.poll();
                if (!exists.contains(cur)) continue;
                if (cur > max) max = cur;
            }
//            if (max == Integer.MIN_VALUE) {
//                sb.append("EMPTY\n");
//                continue;
//            }
            sb.append(max).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }
}
