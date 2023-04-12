# # DFS/BFS
# from collections import deque

# def bfs(graph, s_node, visited):
#   queue = deque([s_node])
#   visited[s_node] = True

#   while queue:
#     cur_node = queue.popleft()
#     print(cur_node)
#     for node in graph[cur_node]: # 정렬되어 있다고 가정
#       if not visited[node]:
#         queue.append(node)
#         visited[node] = True

# def dfs(graph, node, visited):
#   visited[node] = True
#   print(node)
#   for next_node in graph[node]:
#     if not visited[next_node]:
#       dfs(graph, next_node, visited)

# visited = [False] * 9
# graph = [[],
#         [2,3,8],
#         [1,7],
#         [1,4,5],
#         [3,5],
#         [3,4],
#         [7],
#         [2,6,8],
#         [1,7]]

# for arr in graph:
#   arr.sort()

# dfs(graph, 1, visited)
# # bfs(graph, 1, visited)


# # 정렬
# 선택 정렬 - 항상 O(N^2)
def selection_sort(arr):
  for i in range(len(arr)):
    min_idx = i
    for j in range(i + 1, len(arr)):
      if (arr[j] < arr[min_idx]):
        min_idx = j
    arr[min_idx], arr[i] = arr[i], arr[min_idx]
  return arr


# 삽입 정렬 - avg: O(N^2) ~ worst: O(N) # 거의 정렬된 데이터일 때 빠름
def insertion_sort(arr):
  for i in range(1, len(arr)):
    for j in range(i - 1, 0, -1):
      if arr[j] < arr[j - 1]:
        arr[j], arr[j - 1] = arr[j - 1], arr[j]
      else:
        break
  return arr


# 퀵 정렬 - avg: O(NlogN) ~ worst: O(N^2)
# worst : 데이터가 거의 정렬되어 있을 때
# 언어의 기본 sort 함수는 퀵 정렬을 기반으로 하는 경우에도 추가 처리로 O(NlogN) 보장
def quick_sort(arr, start, end):
  if start >= end: return

  pivot = start
  left = start + 1
  right = end
  while left <= right:
    while left <= end and arr[left] <= arr[pivot]:
      left += 1
    while right > start and arr[right] >= arr[
        pivot]:  # right > start로 해도 left 바로 왼쪽에 멈춘다.(left왼쪽 원소들은 모두 pivot보다 작다)
      right -= 1

    if left > right:
      arr[right], arr[pivot] = arr[pivot], arr[right]
    else:
      arr[left], arr[right] = arr[right], arr[left]

  quick_sort(arr, start, right - 1)  # left
  quick_sort(arr, right + 1, end)  # right


# 계수 정렬 - 특정 범위에서만 사용 가능하나, 매우 빠름(worst: O(N+K) (K = max값))
# 보통 0 <= K <= 1,000,000인 경우 사용 가능
# 중간에 빈 구간이 없고, 중복값이 많을 때 효과적
def count_sort(arr):
  cnts = [0] * (max(arr) + 1)

  for i in arr:
    cnts[i] += 1
  arr.clear()
  for i in range(len(cnts)):
    for j in range(cnts[i]):
      arr.append(i)


# 합병 정렬 - 분할정복 방식 / O(NlogN)
# 단점 : 추가 메모리 공간이 필요하다(O(N))
def merge_sort(arr):
  if len(arr) < 2: return arr

  mid = len(arr) // 2
  left_arr = merge_sort(arr[:mid])
  right_arr = merge_sort(arr[mid:])

  merged_arr = []
  l = h = 0
  while l < len(left_arr) and h < len(right_arr):
    if left_arr[l] > right_arr[h]:
      merged_arr.append(left_arr[l])
      l += 1
    else:
      merged_arr.append(right_arr[h])
      h += 1
  # 어느 한 쪽이 먼저 떨어지면
  merged_arr.extend(left_arr[l:])
  merged_arr.extend(right_arr[h:])
  return merged_arr


# arr = [3, 4, 2, 5, 1, 6, 9]
# # selection_sort(arr)
# # insertion_sort(arr)
# # quick_sort(arr, 0, len(arr)-1)
# # count_sort(arr)
# arr = merge_sort(arr)

# print(arr)

# 이진 탐색
def binary_search_recur(arr, target, start, end):
  "이진탐색 - 재귀 방식"
  if start > end: return # start==end(length=1)일 때도 target이 아니어서 한번 더 재귀된 상태 -> 해당 원소 없음

  mid = (start + end) // 2
  # 재귀
  if arr[mid] == target: return mid
  elif arr[mid] > target: return binary_search_recur(arr, target, start, mid-1)
  else: return binary_search_recur(arr, target, mid+1, end)

def binary_search_loop(arr, target):
  "이진탐색 - 반복문 방식"
  start, end = 0, len(arr)
  
  while (start <= end):
    mid = (start + end) // 2
    if arr[mid] == target:
      return mid
    elif arr[mid] > target: # target이 왼쪽에 있음 ->
      end = mid-1 # 왼쪽 탐색
    else:
      start = mid+1

# n, target = list(map(int, input().split()))
n, target = 10, 11

# arr = list(map(int, input().split()))
arr = [1,3,5,7,9,11,13,15,17,19]

# result = binary_search_recur(arr, target, 0, n-1)
result = binary_search_loop(arr, target)
print(result if result != None else "해당 원소가 없습니다.")
