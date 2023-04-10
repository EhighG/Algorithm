curP = input()
cols = [0,'a','b','c','d','e','f','g','h']
moves = [[-2,-1],[-2,1],[2,-1],[2,1], # 상, 하 중심 이동
        [-1,-2], [1,-2],[-1,2],[1,2]] # 좌, 우 중심 이동
cnt = 0

curR = int(curP[1])
curC = cols.index(curP[0])
# or using ord(curP[0]) - ord('a') / ord() = str -> Unicode

for move in moves:
  newR = curR + move[0]
  newC = curC + move[1]
  if ((1 <= newR and newR <= 8) and (1 <= newC and newC <= 8)):
    cnt += 1
print(cnt)