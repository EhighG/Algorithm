package programmers.kakao;

public class CraneGame {
    public static void main(String[] args) {
        int [][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};


    }
    public int solution(int[][] board, int[] moves) {
        Stack stack = new Stack(moves.length);
        for (int move : moves) {
            int innerIndex = move-1;
            for (int i = 0; i < board.length; i++) {
                if (board[i][innerIndex] != 0) {
                    stack.push(board[i][innerIndex]);
                    board[i][innerIndex] = 0;
                    break;
                }
            }
        }
        return stack.getCnt();
    }
    public class Stack {
        private int[] stack;
        private int top;
        private int cnt;

        public Stack(int size) {
            stack = new int[size];
            top = cnt = 0;
        }

        public void push(int dollType) {
            if (stack[top] == dollType) bomb();
            else stack[++top] = dollType;
        }

        public void bomb() {
            stack[top--] = 0;
            cnt += 2;
        }
        public int getCnt() { return this.cnt; }
    }
}
