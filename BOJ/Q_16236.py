# # 아기 상어
from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
arr = [[*map(int, input().split())] for _ in range(n)]
start = (-1, -1)
for r in range(n):
    for c in range(n):
        if arr[r][c] == 9: start = (r, c)
moves = [(-1,0), (1,0), (0,-1), (0,1)]
shark_size = 2

def check(r, c):
    global shark_size
    if not (0 <= r < n and 0 <= c < n) or costs[r][c] != 0: return 0 # not passable
    target = arr[r][c]
    if target > shark_size: return 0
    if target == shark_size or target == 0: return 1 # passable
    else: return 2 # eatable


def bfs(s, costs): # return next_pos, time or 0, 0
    q = deque()
    q.append(s)
    costs[s[0]][s[1]] = 1
    time = 0
    while q:
        sub_q = deque()
        for i in q:
            sub_q.append(i)
        q.clear()
        new_pos = (n,n)
        time += 1
        while sub_q:
            cur = sub_q.popleft()
            # print(cur)
            r, c = cur[0], cur[1]
            for move in moves:
                nr, nc = r + move[0], c + move[1]
                status = check(nr, nc) # 0: not passable, 1: passable, 2: eatable
                if status == 0: continue # not in range or bigger than shark
                if status == 2: # eatable
                    if nr > new_pos[0] or (nr == new_pos[0] and nc > new_pos[1]): continue
                    new_pos = (nr, nc)
                costs[nr][nc] = time
                q.append((nr, nc))
        if new_pos[0] != n: return new_pos, time
    return 0, 0



time = 0
eat_cnt = 0
cur = start
while True:
    costs = [[0]*n for _ in range(n)]
    new, cost = bfs(cur, costs)
    if new == 0:
        break
    # eat
    arr[cur[0]][cur[1]] = 0
    arr[new[0]][new[1]] = 9
    cur = new
    eat_cnt += 1
    if eat_cnt == shark_size: # 레벨업
        shark_size += 1
        eat_cnt = 0
    time += cost
print(time)

# # 연습 - 토마토
# from collections import deque
#
# sys.stdin.readline
#
# m, n = map(int, input().split())
# box = [[*map(int, input().split())] for _ in range(n)]
# moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]
# starts = []
# fresh_num = 0
#
# for r in range(len(box)):
#     for c in range(len(box[0])):
#         if box[r][c] == 0:
#             fresh_num += 1
#         elif box[r][c] == 1:
#             starts.append((r, c))
#
#
# def is_valid(r, c):
#     return 0 <= r < n and 0 <= c < m and box[r][c] == 0
#
#
# def bfs(starts, fresh_num):
#     q = deque(starts)
#     days = -1  # day 0 루프가 끝났을 때, 0이어야 함
#     while q:
#         sub_q = deque(q)
#         q.clear()
#         while sub_q:
#             cur = sub_q.popleft()
#             r, c = cur[0], cur[1]
#             for move in moves:
#                 nr, nc = r + move[0], c + move[1]
#                 if is_valid(nr, nc):
#                     q.append((nr, nc))
#                     box[nr][nc] = 1
#                     fresh_num -= 1
#         days += 1
#     return days if fresh_num == 0 else -1
#
#
# if fresh_num == 0:
#     print(0)
# else:
#     print(bfs(starts, fresh_num))
# import sys
# input =
#
