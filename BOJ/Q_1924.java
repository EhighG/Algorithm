package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1924 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int month = Integer.parseInt(st.nextToken())-1;
        int date = Integer.parseInt(st.nextToken());

        int[] daysOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] daysOfWeek = {"SUN","MON","TUE","WED","THU","FRI","SAT"};

        int days = date;
        for (int i = 0; i < month; i++) {
            days += daysOfMonth[i];
        }

        System.out.println(daysOfWeek[days%7]);
    }
}
