package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Q_2480 {

	public static void main(String[] args) throws IOException {
		// 상금 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int dice1 = Integer.parseInt(st.nextToken());
		int dice2 = Integer.parseInt(st.nextToken());
		int dice3 = Integer.parseInt(st.nextToken());
		int prize;
		
		if(dice1 == dice2 && dice2 == dice3) { // 모든 눈금이 같을 때
			prize = 10000 + dice1*1000;
		} else if (dice1 == dice2 || dice2 == dice3 || dice1 == dice3) { 
			// 같은 눈금이 2개일 때 --> 같은 값 찾기
			prize = (dice1 == dice2)? dice1 : dice3;
			prize = prize*100 + 1000;
		} else { // 같은 눈금이 없을 때 --> 최대값 찾기
			int max = (dice1 >= dice2)? dice1 : dice2;
			prize = (max >= dice3)? max*100 : dice3*100;
		}
		System.out.println(prize);
	}

}
