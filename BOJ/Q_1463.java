package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1463 {

//    static Integer[] dpTable;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
//        dpTable = new Integer[x+1];

//        System.out.println(findMinCnt(x));
        System.out.println(findMinCnt(x, 0));
    }

//    private static int findMinCnt(int x) {
//        if (x == 1) return 0; // 1이하의 정수가 나오는 경우는 없음
//
//        if (dpTable[x] == null) { // x가 이미 방문한 숫자가 아닐 때,
//            // 가능한 모든 경우의 수를 모두 실행해본다.
//            if (x % 6 == 0) {
//                dpTable[x] = Math.min(findMinCnt(x/3), Math.min(findMinCnt(x/2), findMinCnt(x-1))) + 1;
//            } else if (x % 3 == 0) {
//                dpTable[x] = Math.min(findMinCnt(x/3), findMinCnt(x-1)) + 1;
//            } else if (x % 2 == 0) {
//                dpTable[x] = Math.min(findMinCnt(x/2), findMinCnt(x-1)) + 1;
//            } else {
//                dpTable[x] = findMinCnt(x-1) + 1;
//            }
//        }
//        return dpTable[x];
//    }

    private static int findMinCnt(int x, int cnt) {
        if (x < 2) return cnt; // x가 1씩만 줄어드는 이전 방식과 달리, 1을 지나치고 0이 될 수 있다.(ex. x= 6 -> 2 -> 0)

        return Math.min(findMinCnt(x/3, ++cnt + x%3), findMinCnt(x/2, cnt + x%2));
    }
}
