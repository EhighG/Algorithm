N = int(input())
values = list(map(int, input().split()))
values.sort()

cur_value = -1
cnt = 0
group = []

for i in values:
  cur_value = max(cur_value, i) # 현재 그룹 인원들의 max(공포도)
  group.append(i)
  if len(group) >= cur_value: # 모든 인원의 공포도를 충족했다면,
    cnt += 1
    group.clear()

print(cnt)