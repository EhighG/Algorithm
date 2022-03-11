package Baekjoon;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Q_2753 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int result = 0; // 기본값 0
		
		if (input % 4 == 0) {
			// 4의 배수들 중,
			if (!(input%100==0 && input%400!=0)) {result = 1;}
			// 윤년이 아닌 것(100의 배수이면서, 400의 배수가 아닌 것)을 제외한 나머지 >> 1
		}
		
		System.out.println(result);
	}
}
