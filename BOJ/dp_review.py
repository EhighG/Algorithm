import sys
input = sys.stdin.readline

# # Q_1912) 연속합
# n = int(input())
# arr = list(map(int, input().split()))
# dp = [[0]*n for _ in range(2)] # [0]: cur_sum, [1]: max_sum

# dp[0][0] = dp[1][0] = arr[0]

# for i in range(1, n):
#   # cur_sum
#   dp[0][i] = max(dp[0][i-1] + arr[i], arr[i])
#   # max_sum
#   dp[1][i] = max(dp[1][i-1], dp[0][i])
# print(dp[1][-1])

# # Q_1149) RGB 거리
# n = int(input())
# costs = [list(map(int, input().split())) for _ in range(n)] # n*3
# dp = [[0]*3 for _ in range(n)]

# for i in range(3):
#   dp[0][i] = costs[0][i]

# for i in range(1, n):
#   for j in range(3):
#     a, b = 0, 0
#     if j == 0:
#       a, b = 1, 2
#     elif j == 1:
#       a, b = 0, 2
#     else:
#       a, b = 0, 1
      
#     dp[i][j] = min(dp[i-1][a], dp[i-1][b]) + costs[i][j]

# print(min(dp[-1]))

# # Q_2156) 포도주 시식
# n = int(input())
# arr = [0]
# arr += [int(input()) for _ in range(n)]

# if n < 3:
#   print(sum(arr))
#   exit(0)

# dp = [0] * (n+1)
# dp[1] = arr[1]
# dp[2] = arr[1] + arr[2]

# for i in range(3, n+1):
#   dp[i] = max(dp[i-1], # cur 안먹
#              dp[i-2] + arr[i], # cur-1 안먹
#              dp[i-3] + arr[i-1] + arr[i] # cur-2 안먹
#              )
# print(dp[-1])

# # Q_1463) 1로 만들기
# n = int(input())
# dp = [n]*(n+1)
# dp[0] = 0
# dp[1] = 0
#
# def find_min(target):
#     if dp[target] == n:
#         dp[target] = min(find_min(target//3)+(target%3)+1, find_min(target//2)+(target%2)+1)
#     return dp[target]
#
# print(find_min(n))

# Q_11726) 2xn 타일링
# n = int(input())
# dp = [0] * (n+1)
# dp[1] = 1
# dp[2] = 2
#
# for i in range(3, n+1):
#     dp[i] = (dp[i-1] + dp[i-2]) % 10007
#
# print(dp[n])

s1 = [0]*10000
for i in range(1, 10000):
    si = str(i)
    sum = i
    for j in range(len(si)):
        sum += int(si[j])
    s1[i] = sum

for i in range(1, 10000):
    if s1[i] == 0:
        print(i)