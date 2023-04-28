# while True:
n = int(input())
sweets = [list(input()) for _ in range(n)]

def isValid(pos):
  return 0 <= pos[0] and pos[0] < n and 0 <= pos[1] and pos[1] < n

def find_max(cur_map, cur_pos):
  adj = [[cur_pos[0],cur_pos[1]] for _ in range(4)]
  lengths = [0 for _ in range(4)]
  for i in range(4):
    length = 0
    for j in range(n):
      adj[i] = [adj[i][0]+direction[i][0], adj[i][1]+direction[i][1]]
      if isValid(adj[i]) and cur_map[cur_pos[0]][cur_pos[1]] == cur_map[adj[i][0]][adj[i][1]]:
        length += 1
      else: break
    lengths[i] = length
  return max(lengths[0]+lengths[1], lengths[2]+lengths[3]) + 1
  
direction = [[0, -1], [0, 1], [-1, 0] , [1, 0]] # 좌,우,상,하

max_len = 1

for row in range(len(sweets)):
  for col in range(len(sweets[0])):
    for pos in direction:
      # swap
      new_pos = [row+pos[0], col+pos[1]]
      if not isValid(new_pos): continue
      temp_map = [row[:] for row in sweets]
      temp_map[row][col], temp_map[new_pos[0]][new_pos[1]] = temp_map[new_pos[0]][new_pos[1]], temp_map[row][col]

      # find length
      # len_vir = 1
      # len_hor = 1
      # right = [row,col]
      # below = [row,col]
      # for i in range(n):
      #   right = [right[0], right[1]+direction[1][1]]
      #   below = [below[0]+direction[3][0], below[1]]
      #   if not (isValid(right) or isValid(below)):
      #     break
      #   if isValid(below) and temp_map[below[0]][below[1]] == temp_map[row][col]:
      #     len_vir += 1
      #   if isValid(right) and temp_map[right[0]][right[1]] == temp_map[row][col]:
      #     len_hor += 1
      max_len = max(max_len, find_max(temp_map, [row,col]))

print(max_len)

import sys
input = sys.stdin.readline

N = int(input())
d1 = [[1, 0], [0, 1]] # 하, 우
d2 = [[[1, 0], [-1, 0]], [[0, 1], [0, -1]]] # 하, 상, 우, 좌
arr = [list(input())[:-1] for _ in range(N)]
max_count = 0

for i in range(N): # row
  for j in range(N): # col
    for dr, dc in d1: # 방향
      nr, nc = i + dr, j + dc
      org_nr, org_nc = nr, nc
      tmp = 1
      while 0 <= org_nr < N and 0 <= org_nc < N and arr[i][j] == arr[org_nr][org_nc]:
        tmp += 1
        org_nr += dr
        org_nc += dc
      # update max_cnt
      if max_count < tmp:
        max_count = tmp
      # swap
      if 0 <= nr < N and 0 <= nc < N and arr[i][j] != arr[nr][nc]:
        arr[i][j], arr[nr][nc] = arr[nr][nc], arr[i][j]
        # 
        for dd in d2: # d2 = [[하,상], [우,좌]]
          count1 = 1
          count2 = 1
          for dr2, dc2 in dd:
            new_i, new_j = i + dr2, j + dc2
            new_nr, new_nc, = nr + dr2, nc + dc2
            while 0 <= new_nr < N and 0 <= new_nc < N and arr[nr][nc] == arr[new_nr][new_nc]:
              count1 += 1
              new_nr += dr2
              new_nc += dc2
            while 0 <= new_i < N and 0 <= new_j < N and arr[i][j] == arr[new_i][new_j]:
              count2 += 1
              new_i += dr2
              new_j += dc2
          if max_count < count1:
              max_count = count1
          if max_count < count2:
              max_count = count2
        arr[i][j], arr[nr][nc] = arr[nr][nc], arr[i][j]
        print(max_count)