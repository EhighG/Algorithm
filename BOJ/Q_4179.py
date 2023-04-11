from collections import deque
import sys

def valid(maze, pos):
  r,c = pos[0], pos[1]
  n = len(maze)
  m = len(maze[0])
  return 0 <= r and r < n and 0 <= c and c < m

def bfs(maze, s_j, s_f):
  moves = [[-1,0],[1,0],[0,-1],[0,1]] # 상하좌우
  tq_j = deque([s_j]) # 지훈이가 이동 가능한 칸
  tq_f = deque([s_f]) # 불이 번질 칸
  time = 0
  
  # 최초 방문처리
  maze[s_j[0]][s_j[1]] = time

  while tq_j:
    tempq_j = deque(tq_j)
    tempq_f = deque(tq_f)
    time += 1
    while tempq_j:
      cur_j = tempq_j.popleft()
      if tempq_f:
        cur_f = tempq_f.popleft()
        
        # fire 처리 먼저
        for move in moves:
          new_f = [cur_f[0] + move[0], cur_f[1] + move[1]]
          # validation
          if not valid(maze, new_f): continue
          if maze[new_f[0]][new_f[1]] == "#": continue
          # visited
          tq_f.append(new_f)
          maze[new_f[0]][new_f[1]] = "F"
        
      # 사람 이동 처리
      for move in moves:
        new_j = [cur_j[0] + move[0], cur_j[1] + move[1]]
        # 탈출 및 validation 체크
        if not valid(maze, new_j): return time
        if maze[new_j[0]][new_j[1]] != ".": continue
        # visited
        tq_j.append(new_j)
        maze[new_j[0]][new_j[1]] = time
  return -1

# main
R, C = map(int, sys.stdin.readline().split())
maze = []

for r in range(R):
  maze.append(list(sys.stdin.readline()))

start_j = -1
start_f = -1

for r in range(len(maze)):
  for c in range(len(maze[0])):
    cur = maze[r][c]
    if cur == "J": start_j = [r, c]
    elif cur == "F": start_f = [r, c]
      
    if start_j != -1 and start_f != -1:
      time = bfs(maze, start_j, start_f)
      print(time if time != -1 else "IMPOSSIBLE")
      exit()
    # else:
    #   print(0)

        
        