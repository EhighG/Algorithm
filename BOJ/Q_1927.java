package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q_1927 {
    // 최소 힙
    // 구현 : add(int num), pop(minVal)
    static ArrayList<Integer> minHeap;
    static int size = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        minHeap = new ArrayList(N+1);
        minHeap.add(-1);

        while (N --> 0) {
            int instruction = Integer.parseInt(br.readLine());
            if (instruction == 0) sb.append(pop()).append("\n");
            else add(instruction);

        }
        System.out.println(sb);
    }

    public static void add(int input) {
        minHeap.add(input);
        size++;
        if (size == 1) {
            return; // 값이 하나밖에 없을 때
        }
        int currentIndex = size;
        int parentIndex = currentIndex/2;

        // heapify
        while(currentIndex > 1 && minHeap.get(currentIndex) < minHeap.get(parentIndex)) { // 부모 노드가 있고 그것보다 값이 작으면
            // swap
            swap(currentIndex, parentIndex);

            currentIndex/=2;
            parentIndex/=2;
        }
    }


    public static int pop() {
        if (size == 0) return 0;
        int result = minHeap.get(1);
        minHeap.set(1, minHeap.get(size));
        size--;

        // heapify
        int currentIndex = 1;
        int leftChildIndex = 2, rightChildIndex = 3;

        while (leftChildIndex <= size) {
            int minVal = minHeap.get(leftChildIndex);
            int minPos = leftChildIndex;

            if (rightChildIndex <= size && minHeap.get(rightChildIndex) < minVal) { // rightChild가 존재하고, 값이 (왼쪽보다) 더 작으면
                minVal = minHeap.get(rightChildIndex);
                minPos = rightChildIndex;
            }

            if (minHeap.get(currentIndex) < minVal) break;

            swap(currentIndex, minPos);

            currentIndex = minPos;
            leftChildIndex = currentIndex*2;
            rightChildIndex = leftChildIndex+1;
        }

        return result;
    }

    public static void swap(int index1, int index2) {
        int tmp = minHeap.get(index1);
        minHeap.set(index1, minHeap.get(index2));
        minHeap.set(index2, tmp);
    }


}