package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Q_9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader : 입력값을 일정 길이의 버퍼 단위로 끊어서 불러옴.
        int score = Integer.parseInt(br.readLine());
        
        char grade; // 성적을 저장할 변수
        
        switch (score / 10) { // int형끼리의 연산이므로, 결과값은 소수점 이하는 버려진 int형이다.
            case 10: case 9:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            case 6:
                grade = 'D';
                break;
            default:
                grade = 'F';
        }
        System.out.println(grade);
        
    }
}
