# Q_9461) 파도반 수열
T = int(input())
Ns = [int(input()) for _ in range(T)]
max = max(Ns)

dp = [1,1,1]
dp.append(dp[0] + dp[2]) # dp[3]
dp.append(dp[3]) # dp[4]

if max > 4:
  for i in range(5, max):
    dp.append(dp[i-5] + dp[i-1])

for t in Ns:
  print(dp[t-1])

# 풀이 2: dp[n] = dp[n-2] + dp[n-3] 도 가능