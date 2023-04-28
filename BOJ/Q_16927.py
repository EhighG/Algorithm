# 배열 돌리기 1과 동일, R만 ~ 10억
# deque.rotate(-(R % len(deque)))

# max 연산횟수 : 300/2 * len(dq)(-> 4 ~ 약 1200))
from collections import deque
import sys

input = sys.stdin.readline

n, m, r = map(int, input().split())
arr = [input().split() for _ in range(n)]

max_layer = min(n, m)//2

for l in range(max_layer):
  dq = deque()

  # 현재 layer 삽입(중복 주의)
  dq.extend(arr[l][l:m-l]) # 윗변
  dq.extend([row[m-1-l] for row in arr[l+1:n-l]]) # 오른쪽 변 / 중복되는 요소 제외
  dq.extend(arr[n-1-l][l:m-l-1][::-1]) # 아랫 변 / 순서 주의
  dq.extend([row[l] for row in arr[l+1:n-1-l][::-1]]) # 왼쪽 변 / 순서 주의

  # r mod len(dq) 만큼 회전
  dq.rotate(-(r % len(dq)))

  # 결과 write(넣었던 순서 그대로)
  arr[l][l:m-l] = [dq.popleft() for i in range(l, m-l)]
  for i in range(l+1, n-l):
    arr[i][m-1-l] = dq.popleft()
  arr[n-1-l][l:m-1-l] = [dq.popleft() for i in range(l,m-1-l)][::-1]
  for i in range(n-l-2, l, -1):
    arr[i][l] = dq.popleft()

for row in arr:
  print(' '.join(row))
