package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_11279 {
    // 최대 힙
    // 구현 : add(int num), pop(maxVal)
    static int[] maxHeap;
    static int size = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        maxHeap = new int[N+1];

        while (N --> 0) {
            int instruction = Integer.parseInt(br.readLine());
            if (instruction == 0) sb.append(pop()).append("\n");
            else add(instruction);

        }
        System.out.println(sb);
    }

    public static void add(int input) {
        maxHeap[++size] = input;
        if (size == 1) return; // 값이 하나밖에 없을 때
        int currentIndex = size;
        int parentIndex = currentIndex/2;

        // heapify
        while(currentIndex > 1 && maxHeap[currentIndex] > maxHeap[parentIndex]) { // 부모 노드가 있고 그것보다 값이 크면
            // swap
            swap(currentIndex, parentIndex);

            currentIndex/=2;
            parentIndex/=2;
        }
    }


    public static int pop() {
        if (size == 0) return 0;

        int result = maxHeap[1];
        maxHeap[1] = maxHeap[size];
        maxHeap[size--] = 0;

        // heapify
        int currentIndex = 1;
        int leftChildIndex = 2, rightChildIndex = 3;

        while (leftChildIndex <= size) {
            int maxVal = maxHeap[leftChildIndex];
            int maxPos = leftChildIndex;

            if (rightChildIndex <= size && maxHeap[rightChildIndex] > maxVal) { // rightChild가 존재하고, 값이 더 크면
                maxVal = maxHeap[rightChildIndex];
                maxPos = rightChildIndex;
            }

            if (maxHeap[currentIndex] > maxVal) break;

            swap(currentIndex, maxPos);

            currentIndex = maxPos;
            leftChildIndex = currentIndex*2;
            rightChildIndex = leftChildIndex+1;
        }

        return result;
    }

    public static void swap(int index1, int index2) {
        int tmp = maxHeap[index1];
        maxHeap[index1] = maxHeap[index2];
        maxHeap[index2] = tmp;
    }


}
