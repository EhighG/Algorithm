package BOJ;

import java.io.*;

public class Q_2447 {

    static char[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int range = Integer.parseInt(br.readLine());

        stars = new char[range][range];

        draw(0, 0, range, true);

        for (char[] cArr : stars) {
            for (char c : cArr) {
                sb.append(c);
            }
            sb.append("\n");
        }
        sb.toString();
    }

    private static void draw(int sr, int sc, int range, boolean drawable) {
        int SC = sc;
        if (range == 1) {
            stars[sr][sc] = drawable ? '*' : ' ';
            return;
        }
        range /= 3;
        for (int i = 0; i < 9; i++) { // 줄바꿈
            if (i == 2 || i == 5) {
                draw(sr, sc, range, drawable);
                sr += range;
                sc = SC;
            }
            else if (i == 4) { // 빈칸
                draw(sr, sc, range, false);
                sc += range;
            }
            else {
                draw(sr, sc, range, drawable);
                sc += range;
            }
        }
    }
}
