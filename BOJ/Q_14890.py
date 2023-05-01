import sys
input = sys.stdin.readline


N, L = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
possible = [[True] * N for _ in range(N*2)]
# print(f"{type(possible)}, {type(possible[0])}, {len(possible)}, {len(possible[0])}")
# print(possible, sep="\n")

arr.extend(map(list, zip(*arr)))

cnt = 0
for i in range(len(arr)): # O(2N)
  valid = True
  for j in range(len(arr[i])-1): # O(2N^2)
    if arr[i][j+1] != arr[i][j]:
      dir = arr[i][j] - arr[i][j+1] # 다음것이 크면 앞을, 작으면 뒤를 탐색
      # 높이차이 체크
      if abs(dir) != 1:
        valid = False
        break
      nj = j if arr[i][j] > arr[i][j+1] else j+1
      base_height = arr[i][nj]
      for k in range(L): # O(2N^2 * L) = O(N^2 * L) = O(N^3)
        nj += dir
        # 범위 체크
        if not 0 <= nj < N:
          valid = False
          break
        # 높이 체크
        elif arr[i][nj] != base_height-1:
          valid = False
          break
        # 경사로 중복 체크
        elif not possible[i][nj]:
          valid = False
          break
          
        possible[i][nj] = False
  if valid: 
    cnt += 1
    
print(cnt)