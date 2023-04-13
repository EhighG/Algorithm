N, M = map(int, input().split())
coin_types = [int(input()) for _ in range(N)]
dp = [0 for _ in range(M+1)] # 0 ~ M

# # 방법 1: 1번의 DP 안에 반복문 넣기 / 연산 수: 약 10MN + ~
# for coin_type in coin_types:
#   dp[coin_type] = 1

# for i in range(1, M+1):
#   if dp[i] == 1: continue
    
#   min_pre = 10000 # 가능한 최대값 : 1원짜리로 (M - coin_type)원을 구성할 때
#   for coin_type in coin_types:
#     if i <= coin_type: continue

#     pre = dp[i - coin_type]
    
#     if pre < min_pre and pre != 0:
#       min_pre = pre
#   dp[i] = min_pre + 1 if min_pre != 10000 else 0 # M < 20000인 경우에만 유효함

# 방법 2: DP 여러번 돌리기 / 연산 수: 약 6MN + ~ & 바깥쪽 loop 수가 적음 -> 더 빠르다
dp = [10001 for _ in range(M+1)] # 기본값이 dp[i] 산출 과정의 min 연산에서 걸러지게 하기 위함
dp[0] = 0 # 반복문 돌며 dp[coin_type] = 1 해주는 것보다 효율적

for coin_type in coin_types:
  for i in range(coin_type, M+1):
    new_pre_idx = i - coin_type
    
    dp[i] = min(dp[i], dp[new_pre_idx]+1) # 기존 것보다 new가 작으면 갱신


print(dp[:M+1])
print(dp[M] if dp[M] != 10001 else -1)
