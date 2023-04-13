N = int(input())

storage = [0]
storage.extend(list(map(int, input().split()))) # map -> list 변환방법 주의
dp = [0] * len(storage)

dp[1] = storage[1]
dp[2] = max(storage[1], storage[2])

for i in range(3, len(dp)):
  dp[i] = max(dp[i-2]+storage[i], dp[i-1])

print(dp[N])