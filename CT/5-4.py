from collections import deque
def can_go(r, c, maze):
  N = len(maze)
  M = len(maze[0])
  return 0 <= r and r < N and 0 <= c and c < M and maze[r][c] == 1
  
def bfs(maze, start):
  moves = [[-1,0], [1,0], [0,-1], [0,1]]
  TQ = deque([start])
  maze[start[0]][start[1]] = 0 # 방문처리 / 방문한 칸과 괴물 칸 구분 필요 X
  cnt = 0
  
  while TQ:
    cnt += 1
    cntQ = deque(TQ)
    TQ = deque()
    
    while cntQ:
      cur_pos = cntQ.popleft()
      if cur_pos == [len(maze)-1, len(maze[0])-1]:
        return cnt

      for move in moves:
        new_r = cur_pos[0] + move[0]
        new_c = cur_pos[1] + move[1]
        if can_go(new_r, new_c, maze):
          TQ.append([new_r,new_c])
          maze[new_r][new_c] = 0 # 방문처리

N, M = map(int, input().split())
maze = []

for i in range(N):
  maze.append(list(map(int, list(input()))))

print(bfs(maze, [0,0]))