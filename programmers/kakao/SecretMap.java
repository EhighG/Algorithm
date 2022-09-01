package programmers.kakao;

public class SecretMap {

    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[][] decimalMapSet = {arr1, arr2};

        int[] combinedDecimalMap = new int[n];
        String[] binaryMap = new String[n];
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            // 지도 합치기
            combinedDecimalMap[i] = decimalMapSet[0][i] | decimalMapSet[1][i];

            // 십진수 지도 -> 이진수 지도
            String binaryString = Integer.toBinaryString(combinedDecimalMap[i]);
            binaryMap[i] = "0".repeat(n-binaryString.length()) + binaryString; // String.repeat(int count) : Java 11 이상

            // 이진수 지도 -> 해석된 지도
            answer[i] = binaryMap[i]
                    .replace('0', ' ')
                    .replace('1', '#');
        }
        return answer;
    }


}
