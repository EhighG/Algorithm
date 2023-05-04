# 풀이 - O(NlogN)
# a와 b가 교차한다 = a[0] & b[0] 과 a[1] & b[1] 의 대소관계가 반대이다.
# 줄을 최대한 적게 없애서 교차를 없앤다 = 교차하지 않는 줄 수를 최대로 남긴다
# = input을 A 기준 오름차순 정렬하고, B 번호로 LIS를 찾는다

def bin_search(arr, n): # arr = list(tuples)
  s = 0
  e = len(arr) - 1
  while s <= e:
    mid = (s+e)//2
    if n < arr[mid][1]:
      e = mid-1
    elif arr[mid][1] < n:
      s = mid+1
    else:
      return mid
  return s

def LIS(arr): # arr = list(tuples)
  lis = [arr[0]]
  for t in arr[1:]:
    if t[1] > lis[-1][1]:
      lis.append(t)
    else:
      idx = bin_search(lis, t[1])
      lis[idx] = t
  return len(lis)
  

import sys
input = sys.stdin.readline

N = int(input())
lines = [tuple(map(int, input().split())) for _ in range(N)]

lines = sorted(lines, key=lambda x: x[0])

print(N - LIS(lines))

# 풀이 2: 기존 dp(O(N^2)) 방식
# dp = [1] * n으로 초기화
# 이중 반복문(i = 0~n-1, j = 0~i) 돌면서, dp[i] = max(dp[i], dp[j]+1)
