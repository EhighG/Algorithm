package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q_1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] timeTable = new int[n][2];
        for (int[] meeting : timeTable) {
            st = new StringTokenizer(br.readLine());
            meeting[0] = Integer.parseInt(st.nextToken());
            meeting[1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(timeTable, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1]; // 2번째 요소 기준 오름차순 정렬
                } else { // 종료시간이 같으면
                    return o1[0] - o2[0]; // ex. {1, 3}, {8, 8}, {4, 8}
                }
            }
        });

        int cnt = 1; // 첫 회의
        int index = 1;
        int[] currentMeeting = timeTable[0];
        while(index < n) {
            if (timeTable[index][0] >= currentMeeting[1]) { // 다음 가능한 회의 중 최적(endTime이 가장 빠른)인 걸로 뽑힘.
                currentMeeting = timeTable[index];
                cnt++;
            }
            index++;
        }
        System.out.println(cnt);
    }
}
