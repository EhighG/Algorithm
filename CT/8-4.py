N = int(input())
dp = [0 for i in range(N+1)]
mod = 796796

dp[1] = 1
dp[2] = 3

for i in range(3, N+1):
  dp[i] = (dp[i-1] + (2 * dp[i-2])) % mod
print(dp[N])