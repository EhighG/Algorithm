N, K = map(int, input().split())
cnt = 0

while N >= K:
  # -1연산
  cnt += N % K
  # N/K 연산
  N //= K
  cnt += 1

cnt += N - 1
print(cnt)