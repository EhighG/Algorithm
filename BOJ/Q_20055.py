from collections import deque
import sys
input = sys.stdin.readline

# n, k = map(int, input().split())
# belt = deque([[False, i] for i in map(int, input().split())])
n, k = 100, 100
belt = deque([[False, 1000] for _ in range(200)])

d_cnt, loop_cnt = 0, 0
while d_cnt < k:
    loop_cnt += 1

    # 벨트 회전
    belt.rotate(1)
    belt[n-1][0] = False

    # 로봇 이동(역순으로. 정순으로 진행하면, 한번에 여러 칸 이동 가능)
    for i in range(n-2, 0, -1):
        if belt[i][0] and belt[i+1][1] > 0 and not belt[i+1][0]:
            belt[i][0] = False
            belt[i+1][0] = True
            belt[i+1][1] -= 1
            if belt[i+1][1] == 0: d_cnt += 1
    belt[n-1][0] = False

    # 로봇 올리기
    if belt[0][1] > 0:
        belt[0][0] = True
        belt[0][1] -= 1
        if belt[0][1] == 0:
            d_cnt += 1

print(loop_cnt)