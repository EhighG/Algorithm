from collections import deque
import sys
input = sys.stdin.readline

# O(N*K)
# 리스트 등 iterable들 인덱스 표기 시, -1 주의하기

T = int(input())
cogs = []
for i in range(T):
    cogs.append(deque(map(int, input().rstrip())))


K = int(input())

for k in range(K):
    start, D = map(int, input().split())
    start -= 1

    # cur
    pre_left, pre_right = cogs[start][6], cogs[start][2]
    cogs[start].rotate(D)
    D *= -1

    d = D
    # left
    # for cog in cogs[start-1:-1:-1]: # 파이썬에선 인덱스 -1을 last로 인식하므로, 루프가 제대로 돌지 않는다.
    for cog in cogs[start-1::-1]: # 이럼 돈다. 으..
        if start == 0: break # 없으면 loop 범위가 arr[-1::-1] 이 되고, 전체 반복됨.
        if cog[2] == pre_left:
            break
        pre_left = cog[6]
        cog.rotate(d)
        d *= -1
    # for i in range(start-1, -1, -1):
    #     if cogs[i][2] == pre_left:
    #         break
    #     pre_left = cogs[i][6]
    #     cogs[i].rotate(d)
    #     d *= -1

    d = D
    # right
    for cog in cogs[start+1:]:
        if cog[6] == pre_right:
            break
        pre_right = cog[2]
        cog.rotate(d)
        d *= -1
cnt = 0
for cog in cogs:
    cnt += cog[0]
print(cnt)