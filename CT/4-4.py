# (A, B) = 북쪽, 서쪽부터 떨어진 칸 수
# map = N x M
# if 왼쪽칸 방문 x -> 방향전환, 방문
# else: 90도 방향전환만
# if 네 방향 다 바다or방문 -> 뒤로 한칸 후 반복. if 뒤가 바다 = 멈춘다.
# 방문 칸 수 출력
# N, M = 3 ~ 50
# 방향 d = 
def isIn(x, y):
  return 0 <= x and x < M and 0 <= y and y < N


N, M = map(int, input().split())
x, y, d = map(int, input().split())
curP = (x, y)
Map = list(list())
visited = list()
cnt = 0

moves = [[0,-1],[1,0],[0,1],[-1,0]] # 북 동 남 서

for i in range(N):
  Map.append(list(map(int, input().split())))
  visited.append([False for i in range(M)])

while True:
  moved = False
  visited[curP[0]][curP[1]] = True
  for i in range(4):
    d = (d+4-1) % 4
    move = moves[d]
    newX = curP[0] + move[0]
    newY = curP[1] + move[1]
    if isIn(newX, newY) and Map[newX][newY] != 1 and not visited[newX][newY]:
        curP = (newX, newY)
        # d = moves.index(move)
        moved = True
        print(f"curX, curY = {curP[0]}, {curP[1]}, d = {d}")
        break
  if not moved:
    move = moves[(d+4-2) % 4]
    newX = curP[0] + move[0]
    newY = curP[1] + move[1]
    if isIn(newX, newY) and Map[newX][newY] != 1:
      print(f"curX, curY = {curP[0]}, {curP[1]}, d = {d}")
      curP = (newX, newY)
    else:
      break

for arr in visited:
  for i in arr:
    if i:
      cnt += 1

print(cnt)
      
        