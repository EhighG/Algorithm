from collections import deque
import sys

# def is_valid(node, paper):
#   r,c = node[0], node[1]
#   n, m = len(paper), len(paper[0])
#   return (0 <= r and r < n) and (0 <= c and c < m) and paper[r][c] == 1
  
def bfs(start):
  global paper
  queue = deque([start])
  paper[start[0]][start[1]] = 0 # visited
  size = 1

  while queue:
    cur_node = queue.popleft()
    for move in moves:
      next_node = [cur_node[0]+move[0], cur_node[1]+move[1]]
      if paper[next_node[0]][next_node[1]] == 1:
        # visited
        queue.append(next_node)
        paper[next_node[0]][next_node[1]] = 0
        size += 1
  return size

n, m = map(int,sys.stdin.readline().split()) # row, col
paper = []
moves = [[-1,0], [1,0], [0,-1], [0,1]] # 상하좌우
cnt = 0

# for i in range(n):
#   paper.append(list(map(int, sys.stdin.readline().split())))

paper = [[0] * (m+2)] \
        + [[0] + list(map(int, sys.stdin.readline().split())) + [0] for i in range(n)] \
        + [[0] * (m+2)]

# main
max_size = 0
for r in range(1, n+1):
  for c in range(1, m+1):
    if paper[r][c] == 1:
      max_size = max(max_size, bfs([r,c]))
      cnt += 1

print(cnt, max_size, sep="\n")
