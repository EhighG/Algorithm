heights = [int(input()) for _ in range(9)]

# def find(k, cur_set):
#   if k == 7:
#     if sum(cur_set) == 100:
#       for i in sorted(cur_set):
#         print(i)
#       exit(0)
#     return
    
#   if sum(cur_set) > 100: return

#   for height in heights:
#     if height not in cur_set:
#       new_set = set(cur_set)
#       new_set.add(height)
#       find(k+1, new_set)

# s1 = set()
# find(0, s1) 

# 나머지 2개를 뺀다
def solve():
  target = sum(heights) - 100
  for i in range(9):
    for j in range(9):
      if i != j and heights[i]+heights[j] == target:
        return set(heights) - set([heights[i], heights[j]])

result = sorted(solve())
for i in result:
  print(i)