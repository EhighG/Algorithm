# # 정답 풀이: dp[n] = max(arr[0~n]을 봉우리로 갖는 LBS의 길이), result = max(dp[n], LIS(n), LDS(n))
# # -> 시간복잡도: O(N^2logN) + O(NlogN) + O(NlogN) = O(N^2logN)

# def _bin_search(lst, n, desc=False):
#   s = 0
#   e = len(lst)-1
#   while s <= e:
#     mid = (s + e) // 2
#     if (not desc and n < lst[mid]) or (desc and n > lst[mid]):
#       e = mid - 1
#     elif (not desc and lst[mid] < n) or (desc and lst[mid] > n):
#       s = mid + 1
#     else:
#       return mid
#   return s

# def LIS(arr, end):
#   lis = [arr[0]]
#   for i in arr[1:end+1]:
#     if i > lis[-1]:
#       lis.append(i)
#     else:
#       idx = _bin_search(lis, i)
#       lis[idx] = i
#   return len(lis)

# def LDS(arr, end, start=0):
#   lds = [arr[start]]
#   for i in arr[start+1:end+1]:
#     if i < lds[-1]:
#       lds.append(i)
#     else:
#       idx = _bin_search(lds, i, True)
#       lds[idx] = i
      
#   return len(lds)

# N = int(input())
# arr = [*map(int, input().split())]

# dp = [1] * N

# for i in range(1, N):
#   cur_lbs = LIS(arr, i) + LDS(arr, N-1, i) - 1
#   dp[i] = max(dp[i-1], cur_lbs)

# result = max(dp[N-1], LIS(arr, N-1), LDS(arr, N-1))
# print(result)

# 풀이 2: O(NlogN)
def _bin_search(lst, n):
  s = 0
  e = len(lst)-1
  while s <= e:
    mid = (s+e)//2
    if n < lst[mid]:
      e = mid-1
    elif lst[mid] < n:
      s = mid+1
    else:
      return mid
  return s
    
    
def LIS(arr):
  dp = [1 for _ in range(N)] # dp[n] = arr[0~n]까지의 수로 가능한 max(len(LIS))
  lst = [arr[0]]
  for i in range(1, N):
    if arr[i] > lst[-1]:
      lst.append(arr[i])
    else:
      idx = _bin_search(lst, arr[i])
      lst[idx] = arr[i]
    dp[i] = len(lst)
  return dp
  
N = int(input())
arr = [*map(int, input().split())]

asc = LIS(arr)
desc = LIS(arr[::-1])[::-1]

answer = 1
for i in range(N): 
  answer = max(answer, asc[i]+desc[i] - 1)

print(answer)



# 삽질 기록

# # answer = max(len(LIS), len(LDS), len(LBS) in arr)
# # LBS = 값의 크기가 언덕 형태를 이루는 수열
# # len(LBS) = max(arr[:n+1]) 찾은 후, len(LIS) in arr[:max] + len(LDS) in arr[max:n+1]
# # 시간복잡도 : O(NlogN) ~ O(N^2) ?
# # 풀이 반례 : 1 4 3 2 5 1 // max값을 안 고를 수 있다!
  
# N = int(input())
# arr = [*map(int, input().split())]
  
#   # 최대값의 idx 찾기
#   # 최대값이 여러 개인 경우, 모든 최대값에 대해 탐색
#   # -> 최악의 경우(모든 i가 동일할 때), O(N^2)의 시간복잡도(N번만큼 LBS_len 산출, 산출 과정 중 이진탐색 과정 pass)

# max_idxs = [0]
# for i in range(1, len(arr)):
#   if arr[i] > arr[max_idxs[0]]:
#     max_idxs = [i]
#   elif arr[i] == arr[max_idxs[0]]:
#     max_idxs.append(i)

# # print(max_idxs)

# # find max LBS_len
# LBS_len = -1
# for max_idx in max_idxs:
#   LBS_len = max(LBS_len, (LIS(arr, max_idx) + LDS(arr, N-1, max_idx))-1)
  
# answer = max(LIS(arr, N-1), LDS(arr, N-1), LBS_len)
# print("LIS = ", LIS(arr, N-1))
# print("LDS = ", LDS(arr, N-1))
# print("LBS = ", LBS_len)
# # 시간복잡도 : O(NlogN) + O(NlogN) + {O(klogk) 
# #             + O((n-k)log(n-k))} when k = max_idx + 1 ~ O(N^2)
# # => O(NlogN) ~ O(N^2)

# print(answer)