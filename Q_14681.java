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
			else System.out.println(2);
		} else {
			if (x > 0) System.out.println(4);
			else System.out.println(3);
		}
		

	}

}
