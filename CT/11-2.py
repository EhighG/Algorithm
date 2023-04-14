nums = list(map(int, list(input())))
ans = 0

for num in nums:
  if ans > 1 and num > 1: # num 조건 빼먹음
    ans *= num
  else: # 0 or 1이면, 더하는게 더 큼
    ans += num
    
print(ans)
    
    