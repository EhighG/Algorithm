nums = list(map(int, list(input())))
group_cnts = [0, 0]

ans = -1
for num in nums:
  if num != ans:
    group_cnts[num] += 1
    ans = num
print(min(group_cnts))