# from collections import deque
# import sys

# input = sys.stdin.readline

# # 입력받기
# n, m, r, c, k = map(int, input().split())
# arr = [input().split() for _ in range(n)]
# opers = list(map(lambda x: int(x)-1, input().split())) # 연산을 0-based로

# hor_sides = deque(['0'] * 4) # L, U, R, D # 초기 자료형 주의! int로 하면 뒤에 map과의 상호작용 부분에서 오류
# ver_sides = deque(['0'] * 4) # F, D, B, U
# moves = [[0,1], [0,-1], [-1,0], [1,0]] # 0, 동서북남

# result = [] # 출력될 (U의) 수들

# for k in opers:
#   is_hor = False
#   if k < 2:
#     is_hor = True

#   # 범위 체크 및 위치 이동
#   nr = r + moves[k][0]
#   nc = c + moves[k][1]
  
#   if (is_hor and not 0 <= nc < m) or (not is_hor and not 0 <= nr < n):
#     continue # 이동 x

#   # r, c 갱신
#   r, c = nr, nc

#   # # 이동
#   # 주사위 굴리기
#   if is_hor:
#     hor_sides.rotate(moves[k][1]) # 진행방향 따라 회전
#     ver_sides[3], ver_sides[1] = hor_sides[1], hor_sides[3] # U, D 동기화
#   else:
#     ver_sides.rotate(moves[k][0])
#     hor_sides[1], hor_sides[3] = ver_sides[3], ver_sides[1]
  
#   # map과의 상호작용
#   if arr[r][c] == '0':
#     arr[r][c] = hor_sides[3]
#   else:
#     hor_sides[3] = arr[r][c]
#     ver_sides[1] = arr[r][c]
#     arr[r][c] = '0'

#   result.append(hor_sides[1])

# print('\n'.join(result))

# 풀이 2: 수직, 수평 list 필요 없이 한 list로 가능
import sys

input = sys.stdin.readline

# 입력받기
n, m, r, c, k = map(int, input().split())
arr = [input().split() for _ in range(n)]
opers = list(map(int, input().split()))

U = '0'
D = '0'
sides = [None] + ['0'] * 4 # None, L, R, B, F]
moves = [None, [0,1], [0,-1], [-1,0], [1,0]] # 0, 동서북남

result = [] # 출력될 (U의) 수들

for k in opers:
  is_hor = False
  if k < 3:
    is_hor = True

  # 범위 체크 및 위치 이동
  nr = r + moves[k][0]
  nc = c + moves[k][1]
  
  if (is_hor and not 0 <= nc < m) or (not is_hor and not 0 <= nr < n):
    continue # 이동 x

  # r, c 갱신
  r, c = nr, nc

  # # 이동
  # 주사위 굴리기
  o = k+1 if k % 2 == 1 else k-1
  U, sides[o], D, sides[k] = sides[k], U, sides[o], D # if move = 동 : L,U,R,D -> U,R,D,L
  
  # map과의 상호작용
  if arr[r][c] == '0':
    arr[r][c] = D
  else:
    D = arr[r][c]
    arr[r][c] = '0'

  result.append(U)

print('\n'.join(result))