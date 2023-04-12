# def quick_sort(arr, start, end, reverse=False):
#   if len(arr) == 1: return
#   pivot = start
#   left = start + 1
#   right = end

#   while left <= right:
#     while left <= end:
#       if (arr[left] <= arr[pivot] if reverse == False else arr[left] >= arr[pivot]):
#         left += 1
#       else: break
#     while right > start:
#       if (arr[right] >= arr[pivot] if reverse == False else arr[right] <= arr[pivot]):
#         right -= 1
#       else: break
#     if left > right:
#       arr[pivot], arr[right] = arr[right], arr[pivot]
#     else:
#       arr[left], arr[right] = arr[right], arr[left]
#     quick_sort(arr, start, right-1, reverse)
#     quick_sort(arr, right+1, end, reverse)

def merge_sort(arr, reverse=False):
  if len(arr) < 2: return arr
  mid = len(arr)//2
  left = merge_sort(arr[:mid], reverse)
  right = merge_sort(arr[mid:], reverse)

  merged_arr = []
  l = r = 0
  while l < len(left) and r < len(right):
    if (reverse == False and left[l] < right[r]) \
    or (reverse == True and left[l] > right[r]):
      merged_arr.append(left[l])
      l += 1
    else:
      merged_arr.append(right[r])
      r += 1
    # 둘 중 하나는 비었으므로, 순서 상관 X
  merged_arr.extend(left[l:])
  merged_arr.extend(right[r:])
  return merged_arr

N, K = map(int, input().split())
arr1 = list(map(int, input().split()))
arr2 = list(map(int, input().split()))

# quick_sort(arr1, 0, N-1)
# quick_sort(arr2, 0, N-1, True)

# 원본이 아닌 새로운 리스트를 반환함. 주의!! 
arr1 = merge_sort(arr1)
arr2 = merge_sort(arr2, True)
print(arr1)
print(arr2)

for i in range(K):
  arr1[i], arr2[i] = arr2[i], arr1[i]

print(sum(arr1))