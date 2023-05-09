import sys
input = sys.stdin.readline

# # 풀이 1: O(NlogN), N = 400,000
#
# n = int(input())
# arr = []
#
# for i in range(n):
#     s, e = map(int, input().split())
#     arr.append([s, 1])
#     arr.append([e, 0]) # 같은 숫자면, end가 먼저 나와야 cnt가 증가하지 않는다.
# arr.sort()
#
# cnt = max_cnt = 0
# for i in arr:
#     cnt += -1 if i[1] == 0 else 1
#     if cnt > max_cnt:
#         max_cnt = cnt
#
# print(max_cnt)

# 풀이 2: O(NlogN), N = 200,000

from heapq import heappush, heapreplace

n = int(input())
arr = sorted(tuple(map(int, input().split())) for _ in range(n)) # tuple = 불변(readOnly)
rooms = [0]

for s, e in arr:
    if s >= rooms[0]: # (종료시간 기준)제일 빠른 수업이 끝난 후에 시작하면,
        heapreplace(rooms, e) # 그 수업 종료시킨 후, 해당 수업 삽입 # 시작시간을 정렬해놨기에 가능함.
    else: # 끝나기 전에 시작하면,
        heappush(rooms, e) # 그대로 둔 채 삽입(강의실 추가)

print(len(rooms))