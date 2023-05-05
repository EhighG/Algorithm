# 정답 풀이:
# 두 문자열 a, b를 순회하는 이중 반복문을 만들고, 각 문자 i와 j를 비교
# dp[i][j] = a[i]까지, b[j]까지 고려했을 때의 LCS 길이
# if i == j: dp[i][j] = dp[i-1][j-1] + 1
# else: dp[i][j] = max(dp[i][j-1], dp[i-1][j])
# -> 한 쪽의 cur_char를 추가했을 때, 그로 인해 LCS가 증가할 수 있기 때문
# ex) a = ACBA, b = AAXY 일 때 ACBA와 AAX의 비교

# 속도 매우 느림. 왜??
import time
import sys
input = sys.stdin.readline

# 중요! input()과 sys.stdin.readline()의 차이점
# : readline은 개행문자까지 받지만, input은 제외하고 받는다.
# -> readline 사용 시 결과 = 정답 + 1

sTime = time.time()
a = input()
b = input()

dp = [[0] * (len(b)+1) for _ in range(len(a)+1)] # index = 1-based

answer = 0
al = len(a)+1
bl = len(b)+1

for i in range(1, al):
  for j in range(1, bl):
    if a[i-1] != b[j-1]:
      dp[i][j] = max(dp[i-1][j], dp[i][j-1])
    else:
      dp[i][j] = dp[i-1][j-1] + 1
    answer = max(dp[i][j], answer)

print(answer-1)
eTime = time.time()
print(eTime - sTime)


# # 삽질 기록

# # 풀이 1:
# # 상대 문자열에서의 위치를 기준으로 LIS를 찾는다
# # 문자열 탐색 -> O(N^2), LIS 찾기 = O(NlogN) when 중복 x, O(N^2) when all 중복
# # --> 중복 처리 불가능 / 오답

# def bin_search(arr, n):
#   s, e = 0, len(arr)-1
#   while s <= e:
#     mid = (s + e)//2
#     if n < arr[mid]:
#       e = mid-1
#     elif arr[mid] < n:
#       s = mid+1
#     else:
#       return mid
#   return s

# a = input()
# b = input()

# arr = [[] for _ in range(len(a))]

# # 문자열 탐색
# for i in range(len(a)):
#   for j in range(len(b)):
#     if a[i] == b[j]:
#       arr[i].append(j)

# # LIS
# lis = []
# i = 1
# for r in arr:
#   if len(r) != 0:
#     lis.append(r[0]) # 위치를 고를 수 있다면, 가장 앞으로 고른다
#     break
#   i += 1
  
# for idxs in arr[i:]:
#   for idx in idxs:
#     if lis[-1] < idx:
#       lis.append(idx)
#       break
#     else:
#       index = bin_search(lis, idx)
#       lis[index] = idx
#   # if len(idxs) == 0: continue
  
#   # lis_set = set(lis)
#   # found = False
  
#   # for i in idxs:
#   #   if i > lis[-1]:
#   #     found = True
#   #     lis.append(i)
#   #     break
      
#   # if found: continue 
    
#   # # 큰 값이 없으면, 중복 아닌 것 중 가장 작은 값(앞 위치) 넣기
#   # val = -1
#   # for i in idxs:
#   #   if i not in lis_set:
#   #     val = i
#   #     break
      
#   # if val == -1: continue # 다 중복이다 = 카운팅 안 해도 된다
    
#   # index = bin_search(lis, val)
#   # lis[index] = val

# print(arr)
# print(lis)
# print(len(lis))