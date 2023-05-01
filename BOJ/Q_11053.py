n = int(input())
arr = list(map(int, input().split()))
def max_tuple(t1, t2):
  if (t1[0] > t2[0]) or (t1[0] == t2[0] and t1[1] < t2[1]):
    return t1
  return t2

dp = [[0]*n for _ in range(2)] # 0: cur포함 max, 1: max

if n == 1:
  print(1)
  exit(0)

dp[0][0] = dp[1][0] = (1, arr[0]) # (길이, max_k)
dp[0][1] = (2, arr[1]) if arr[0] < arr[1] else (1, arr[1])
dp[1][1] = max_tuple(dp[1][0], dp[0][1])

for i in range(2, n): # O(N)
  max = (0, 1001)
  for j in range(i): # O(N^2)
    cur = dp[0][j]
    if cur[1] >= arr[i]: continue # = 인 경우도 추가해야함!

    max = max_tuple(cur, max)
  dp[0][i] = (max[0]+1, arr[i])
  dp[1][i] = max_tuple(dp[1][i-1], dp[0][i])

print(dp[1][n-1][0])
  
# 어차피 O(N^2)으로 풀 거면, 그때그때 max_len을 확인할 수 있으므로 dp 테이블을 2차원으로 할 필요가 없다.
# 마찬가지로 max_k도 그때마다 확인 가능하므로, dp는 max_k를 빼고 len만 저장해도 된다.
# 추가로, 모든 dp[i]가 최소 1은 될 것이므로 처음에 1로 초기화한다.

# 풀이 2:
n = int(input())
arr = [*map(int, input().split())]

dp = [1] * n

for i in range(n):
  for j in range(i):
    if arr[j] < arr[i]:
      dp[i] = max(dp[i], dp[j]+1)

print(dp[n-1])