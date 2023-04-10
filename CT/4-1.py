N = int(input())
move_plans = input().split()
moves = {"L": [0,-1], "R": [0,1], "U":[-1,0], "D":[1,0]}

curP = [1,1]

for move in move_plans:
  d = moves.get(move)
  newP = [curP[0]+d[0], curP[1]+d[1]]
  if (1 <= newP[0] and newP[0] <= N and 1 <= newP[1] and newP[1] <= N):
    curP = newP

print(str(curP[0]) + " " + str(curP[1]))