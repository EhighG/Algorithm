import sys
input = sys.stdin.readline

h, w, x, y = map(int, input().split())
B = [[*map(int, input().split())] for _ in range(h+x)]

# 겹치는 부분 복원
for r in range(x, h): # x, y < h, w
    for c in range(y, w):
        B[r][c] -= B[r-x][c-y]

# print
for i in range(h):
    print(' '.join(map(str, B[i][:w])))