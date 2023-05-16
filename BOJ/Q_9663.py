import sys
input = sys.stdin.readline


def dfs(row):
    global cnt
    if row == n:
        cnt += 1
        return

    for col in range(n):
        if check_col(col, row):
            board[row] = col
            dfs(row+1)


def check_col(col, row):
    for i in range(row):
        if (board[i] == col) or (row - i == abs(col - board[i])): # 수직선 & 대각선 체크
            return False
    return True


n = int(input())
board = [0] * n
cnt = 0

dfs(0)
print(cnt)