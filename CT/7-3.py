# 매개변수 탐색 (최적화 문제 -> 결정(yes/no) 문제)
# N = 떡 수 = 1 ~ 100만
# M = 목표 떡 총량 = 1 ~ 20억
# H = 개별 떡 길이 = 0 ~ 10억

import sys

def bin_search(arr, M):
  start = 0
  end = 1_000_000_000 - 1 # M은 1 이상이므로
  result = 0
  while start <= end:
    mid = (start + end) // 2
    m = 0
    for i in arr:
      if i > mid: m += (i - mid)

    if m < M: # m이 부족하다 = 높이가 높다 = 왼쪽 탐색
      end = mid - 1
    else:
      result = mid # 반복문의 마지막과 가장 가까운, 부족하지 않은 m을 도출하는 mid가 결과값이 됨.
      start = mid + 1
  return result

N, M = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))

print(bin_search(arr, M))