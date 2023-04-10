from collections import deque

def is_valid_pos(r_no, c_no, frame):
  r = len(frame)
  c = len(frame[0])
  return 0 <= r_no and r_no < r and 0 <= c_no and c_no < c

def bfs(frame, start, visited):
  moves = [[-1,0], [1,0], [0,-1], [0,1]] # [row, col] / 상 하 좌 우
  queue = deque([start])
  visited[start[0]][start[1]] = True

  while queue:
    cur_pos = queue.popleft() # [r_no, c_no]
    for move in moves:
      new_r = cur_pos[0] + move[0]
      new_c = cur_pos[1] + move[1]
      if is_valid_pos(new_r, new_c, frame) and frame[new_r][new_c] == 0 and not visited[new_r][new_c]:
        queue.append([new_r, new_c])
        visited[new_r][new_c] = True
      
    

N, M = map(int, input().split())
frame = [[] for i in range(N)]
visited = []
cnt = 0;

for i in range(len(frame)):
  frame[i] = list(map(int, list(input())))
  visited.append([False for i in range(M)])

for r in range(len(frame)):
  for c in range(len(frame[0])):
    if frame[r][c] == 0 and not visited[r][c]:
      bfs(frame, [r, c], visited)
      cnt += 1

print(cnt)