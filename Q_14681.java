package Baekjoon;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_14681 {

	public static void main(String[] args) throws IOException {
		// find quadrant
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		
		if (y > 0) {
			if (x > 0) System.out.println(1);
			else System.out.println(2); // 문제에 x != 0 이라고 명시되어 있으므로, 같은 경우는 고려하지 않는다.
		} else { // 윗줄의 x와 마찬가지로, y=0인 경우는 고려하지 않는다.
			if (x > 0) System.out.println(4);
			else System.out.println(3);
		}
		

	}

}
