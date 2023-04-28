# # 풀이 1 : 실패(시간초과)
# import sys
# input = sys.stdin.readline

# n, m, r = map(int, input().split())
# arr = [list(map(int, input().split())) for _ in range(n)]


# layer = min(n, m)//2

# for i in range(layer): # grid: 0-based
#   # oper1 : right -> left
#   for col in range(m-2-i, i-1, -1):
#     dest[i][col] = arr[i][col+1]
#   # oper2: up -> down
#   for row in range(i+1, n-i):
#     dest[row][i] = arr[row-1][i]
#   # oper3: left -> right
#   for col in range(i+1, m-i):
#     dest[n-1-i][col] = arr[n-1-i][col-1]
#   # oper4: down -> up
#   for row in range(n-2-i, i-1, -1):
#     dest[row][m-1-i] = arr[row+1][m-1-i]

# result = ""
# for i in dest:
#   for j in i:
#     result += f"{j} "
#   result += "\n"
# print(result)

# # // O(n x m x r)

# for _ in range(r):
#   dest = [[0]*m for _ in range(n)]
  
#   for i in range(len(arr)):
#     # s = min(i, n-1-i)
#     # e = max(i, m-1-i)
#     max_layer = min(n, m) // 2
#     cur_layer = min(i, n-1-i, max_layer) # 0-based
#     s = cur_layer
#     e = m-1-cur_layer
  
#     # left part
#     if i != 0:
#       dest[i][:s] = arr[i-1][:s]
#     # cur-layer part
#     if (i < n//2): # ~mid
#       dest[i][s:e] = arr[i][s+1:e+1]
#       dest[i][e] = arr[i+1][e]
#     else: # mid~
#       dest[i][s] = arr[i-1][s]
#       dest[i][s+1:e+1] = arr[i][s:e]
#     # right part
#     if i != n-1:
#       dest[i][e+1:] = arr[i+1][e+1:]

#     # print(f"{i+1}회차 : ")
#     # for i in dest:
#     #   for j in i:
#     #     print(j, end=' ')
#     #   print('\n')

#   arr = dest

# # 풀이 2: O(RxNxM)
# import sys
# input = sys.stdin.readline

# n, m, r = map(int, input().split())
# arr = [list(map(int, input().split())) for _ in range(n)]

# moves = [[1,0], [0,1], [-1,0], [0,-1]] # 하,우,상,좌
# for _ in range(r):
#   carr = [[] for i in range(n)]

#   # deepcopy
#   for i in range(n):
#     carr[i] = arr[i][:]

#   sr, sc, er, ec = 0, 0, n-1, m-1
#   for layer in range(min(n,m)//2):
#     r, c = sr, sc
#     for move in moves:
#       # 막힐 때까지(범위를 벗어나기 전까지) 진행
#       while True:
#         nr = r + move[0]
#         nc = c + move[1]
#         if sr <= nr <= er and sc <= nc <= ec:
#           arr[nr][nc] = carr[r][c]
#           r, c = nr, nc
#         else: # 막히면
#           break
#     # 다 돌면, 안쪽 layer 진행
#     sr += 1
#     sc += 1
#     er -= 1
#     ec -= 1
    
  
# result = ""
# for row in arr:
#   for j in row:
#     result += str(j) + " "
#   result += "\n"

# print(result)

# 풀이 3: O(NxM)
import sys
from collections import deque

input = sys.stdin.readline

n, m, r = map(int, input().split())
max_layer = min(n, m) // 2 # min(n,m) mod 2 = 0

arr = [input().split() for _ in range(n)]

for i in range(max_layer):
  dq = deque()
  # (i, i)가 start, (i+1, i)가 end가 되도록 원소 삽입(시계방향으로)
  dq.extend(arr[i][i:m-1-i]) # right -> left 연산의 dest
  dq.extend([row[-(i+1)] for row in arr[i:n-1-i]]) # down -> up 연산의 dest / 음수 index = 1 based
  dq.extend(arr[-(i+1)][i+1:m-i][::-1]) # left -> right 연산의 dest
  dq.extend([row[i] for row in arr[n-1-i:i:-1]])

  dq.rotate(-r) # 원형 linkedList의 회전 연산(음수 : 왼쪽) / O(R)

  # 넣었던 자리 순서 그대로 pop
  for j in range(i, m-i-1):
    arr[i][j] = dq.popleft()
  for j in range(i, n-1-i):
    arr[j][-(i+1)] = dq.popleft()
  for j in range(m-1-i, i, -1):
    arr[-(i+1)][j] = dq.popleft()
  for j in range(n-1-i, i, -1):
    arr[j][i] = dq.popleft()

for row in arr:
  print(*row)
    
# # 풀이 4: 
# import sys
# input = sys.stdin.readline

# N, M, R = map(int, input().split())
# mtx = [input().split() for _ in range(N)]

# square_cnt = 0
# n, m = N, M
# while n > 0 and m > 0:
#     square_cnt += 1
#     n -= 2
#     m -= 2
# new_square = [[0] * M for _ in range(N)]
# for square_no in range(square_cnt):
#     lst = []
#     # 아랫변
#     lst += mtx[N-square_no-1][square_no:M-square_no]
#     # 오른쪽 변
#     for i in range(N-2-square_no, square_no, -1):
#         lst.append(mtx[i][M-square_no-1])
#     # 윗변
#     if N-square_no-1 != square_no:
#         lst += reversed(mtx[square_no][square_no:M-square_no])
#     # 왼쪽 변
#     if square_no != M-square_no-1:
#         for i in range(square_no+1, N-1-square_no):
#             lst.append(mtx[i][square_no])

#     total_square_count = len(lst)
#     if total_square_count <= 0: 
#         new_square = mtx
#         break
#     move_cnt = R%total_square_count
#     lst = lst[-move_cnt:] + lst[:-move_cnt]


#     new_square[N-square_no-1][square_no:M-square_no] = lst[:M-square_no*2]
#     lst = lst[M-square_no*2:]
#     for i in range(N-2-square_no, square_no, -1):
#         new_square[i][M-square_no-1] = lst.pop(0)
#     if N-square_no-1 != square_no:
#         new_square[square_no][square_no:M-square_no] = reversed(lst[:M-square_no*2])
#         lst = lst[M-square_no*2:]
#     if square_no != M-square_no-1:
#         for i in range(square_no+1, N-1-square_no):
#             new_square[i][square_no] = lst.pop(0)


# print(*[' '.join(s) for s in new_square], sep = '\n')