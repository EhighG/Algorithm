# DFS/BFS
from collections import deque

def bfs(graph, s_node, visited):
  queue = deque([s_node])
  visited[s_node] = True

  while queue:
    cur_node = queue.popleft()
    print(cur_node)
    for node in graph[cur_node]: # 정렬되어 있다고 가정
      if not visited[node]:
        queue.append(node)
        visited[node] = True

def dfs(graph, node, visited):
  visited[node] = True
  print(node)
  for next_node in graph[node]:
    if not visited[next_node]:
      dfs(graph, next_node, visited)


visited = [False] * 9
graph = [[],
        [2,3,8],
        [1,7],
        [1,4,5],
        [3,5],
        [3,4],
        [7],
        [2,6,8],
        [1,7]]

for arr in graph:
  arr.sort()

dfs(graph, 1, visited)
# bfs(graph, 1, visited)
      