package BOJ;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Q_2753 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int result; 
		

		// (4의 배수 && 100의 배수가 아닐 때) or 400의 배수일 때
		if ((input % 4 == 0) && (input % 100 != 0)) {
			result = 1;
		} else if (input % 400 == 0) {
			result = 1;
		} else {result = 0;}
		
		System.out.println(result);
	}
}
