import sys

# 500개의 자연수 정렬하기
def quick_sort(arr, start, end):
  if len(arr) == 1: return
  pivot = start
  left = start + 1
  right = end
  while left <= right:
    while left <= end and arr[left] >= arr[pivot]: # 마지막까지 pivot보다 작은 데이터라면, 엇갈리지 않을 수 있으므로 조건에 left = end 추가
      left += 1
    while right > start and arr[right] <= arr[pivot]: # pivot이 바뀌면 안되므로 right == start는 제외
      right -= 1
    if left > right:
      arr[pivot], arr[right] = arr[right], arr[pivot]
    else:
      arr[left], arr[right] = arr[right], arr[left]
    quick_sort(arr, start, right-1) # pivot 값은 안 건드렸으므로, 현재 arr[right]가 pivot
    quick_sort(arr, right+1, end)

N = int(sys.stdin.readline())
nums = []

for i in range(N):
  nums.append(int(sys.stdin.readline()))

quick_sort(nums, 0, N-1)

for i in nums:
  print(i, end=' ')
print("\n")
    