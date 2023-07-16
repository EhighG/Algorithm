# import sys
# from collections import deque
#
# input = sys.stdin.readline
#
# tc = int(input())
#
# def bfs(arr):
#     q = deque()
#     q.append(0)
#
#     max_dist = 1000
#     while q:
#         cur_i = q.popleft()
#         cur = arr[cur_i]
#         visited[cur_i] = True
#         for i in range(1, n+2):
#             tmp = arr[i]
#             if not visited[i] and (abs(cur[0]-tmp[0]) + abs(cur[1]-tmp[1])) <= max_dist:
#                 q.append(i)
#     print("happy" if visited[-1] else "sad")
#
# for t in range(tc):
#     n = int(input())
#     nodes = [tuple(map(int, input().split())) for _ in range(n + 2)]
#     visited = [False] * (n + 2)
#
#     bfs(nodes)
#
# # 풀이 2
# # dfs
# # end까지 거리가 되면, True 반환
# # stores 돌면서,
# #     이미 방문했으면 continue
# #     아니라면,
# #         방문처리
#
from collections import deque
import sys

sys.setrecursionlimit(10**5)
input = sys.stdin.readline

def visitable(a, b):
    return abs(b[0]-a[0]) + abs(b[1]-a[1]) <= 1000

def solve():
    n = int(input())
    start = tuple(map(int, input().split()))
    stores = [[*map(int, input().split()), False] for _ in range(n)]
    end = tuple(map(int, input().split()))

    # dfs
    def dfs(cur): # tuple or list
        if visitable(cur, end):
            return True
        ret = False
        for store in stores: # [x_pos, y_pos, visited]
            # 방문한 노드 pass
            if store[2] or not visitable(cur, store): continue

            store[2] = True
            ret = ret or dfs(store) # True였다가 덮어씌워지는 것 방지
        return ret

    print("happy" if dfs(start) else "sad")

    # # bfs
    # q = deque()
    # q.append(start)
    # res = False
    #
    # while q:
    #     cur = q.popleft()
    #     if visitable(cur, end):
    #         res = True
    #         break
    #
    #     for store in stores:
    #         if store[2] or not visitable(cur, store): continue
    #         store[2] = True
    #         q.append(store)
    # print("happy" if res else "sad")

T = int(input())

for t in range(T): solve()
