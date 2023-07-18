# # 풀이 1: 내 풀이

# from collections import deque
# import sys
# input = sys.stdin.readline
#
# moves = [[-1,0], [1,0], [0,-1], [0,1]]
#
# n, m = map(int, input().split())
#
# cnt = 0
# divided = False
#
# arr = [[*map(int, input().split())] for _ in range(n)]
#
# def bfs(r, c, visited, melt_cnt): # max : 4 * 10000
#     q = deque()
#     q.append((r, c))
#     visited[r][c] = True
#     # loop_cnt = 0;
#
#     while q:
#         cur = q.popleft()
#         # print(cur)
#         r, c = cur
#
#         for move in moves:
#             nr = cur[0]+move[0]
#             nc = cur[1]+move[1]
#             if arr[nr][nc] == 0:
#                 melt_cnt[r][c] += 1
#                 # print(f"melt+ {r},{c} / (nr,nc) = {nr},{nc}")
#             elif not visited[nr][nc]:
#                 # print(f"append q {r},{c} / (nr,nc) = {nr},{nc}")
#                 q.append((nr,nc))
#                 visited[nr][nc] = True
#         # print(q)
#         # loop_cnt += 1
#     # print(loop_cnt)
#
#
#
# while not divided: # max : 10 * 100
#     divided_cnt = 0
#     melt_cnt = [[0]*m for _ in range(n)]
#     # bfs
#     visited = [[False] * m for _ in range(n)]
#     for i in range(n):
#         for j in range(m):
#             if arr[i][j] != 0 and not visited[i][j]:
#                 # print(f"start = {i}, {j}")
#                 divided_cnt += 1
#                 bfs(i, j, visited, melt_cnt)
#     # for i in arr:
#     #     print(i)
#
#     # 다 녹았을 때
#     if divided_cnt == 0:
#         break
#     # check
#     if divided_cnt > 1:
#         divided = True
#         break
#
#     # if not divided
#     cnt += 1
#
#     # melt
#     for i in range(n):
#         for j in range(m):
#             arr[i][j] -= melt_cnt[i][j]
#             if arr[i][j] < 0: arr[i][j] = 0
#
# print(cnt if divided else 0)

# 풀이 2
# 1) visited 체크 -> sign * 방식으로 대체 -> outer*N*M 리스트 생성비용 감소
# 2) all_elem_num과 cnt 활용 -> divided 검사 비용 감소(전체 탐색 -> int 비교)

import sys

input = sys.stdin.readline

N, M = map(int, input().split())

board = []

all_element = 0

for _ in range(N):
    board.append(list(map(int, input().split())))
    all_element += M - board[-1].count(0)

dy = (1, -1, 0, 0)
dx = (0, 0, 1, -1)


def find_start_point():
    for y in range(N):
        for x in range(M):
            if board[y][x] != 0:
                return (y, x)
    return (0, 0)


start_point = find_start_point()

will_remove = []
stack = []

t = 0
sign = 1

# 하루가 지남에 따라 while loop 한바퀴 돔
while True:
    sign *= -1
    t += 1
    count = 0
    board[start_point[0]][start_point[1]] *= -1
    stack.append(start_point)
    while stack:
        y, x = stack.pop()
        count += 1
        value = 0
        for d in range(4):
            if 0 <= y + dy[d] < N and 0 <= x + dx[d] < M:
                if board[y + dy[d]][x + dx[d]] == 0:
                    value += 1
                elif board[y + dy[d]][x + dx[d]] * sign < 0: # sign = visited 대체 -> visited 생성 비용 감소
                    board[y + dy[d]][x + dx[d]] *= -1 # line a
                    stack.append((y + dy[d], x + dx[d]))

        if board[y][x] * sign - value <= 0:
            will_remove.append((y, x))
        else:
            board[y][x] -= value * sign # line a를 거치면서, sig과 board[y][x] 의 부호가 같아짐.
            start_point = (y, x)

    # 덩어리가 2개 이상인 경우; if True == 다 방문하지 못했을 것
    if count != all_element:
        print(t - 1)
        break

    # 제거될 친구들 제거
    while will_remove:
        y, x = will_remove.pop()
        board[y][x] = 0
        all_element -= 1

    # 언제나 한덩이인 채로 모두 녹았을 경우
    if all_element == 0:
        print(0)
        break