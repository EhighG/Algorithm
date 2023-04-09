def findMaxs(arr):
  max = max_2nd = -1
  for i in arr: # --- O(N)
    if (i > max):
      max_2nd = max
      max = i
    elif (i > max_2nd):
      max_2nd = i

  return max, max_2nd

# --- main - O(M) --> 반복문 최적화 후 O(N)
N, M, K = map(int, input().split())
arr = list(map(int, input().split()))

max, max_2nd = findMaxs(arr)
sum = 0
cur_cnt = K

# for i in range(M):
#   if (cur_cnt > 0):
#     sum += max
#     cur_cnt -= 1
#   else:
#     sum += max_2nd
#     cur_cnt = K

# 반복문 부분 O(1)로 해결 가능
x = M // (K+1)
sum += max_2nd * x
sum += max * (M - x)
print(sum)