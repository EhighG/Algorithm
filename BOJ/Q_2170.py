import sys
input = sys.stdin.readline

n = int(input())
lines = [tuple(map(int, input().split())) for _ in range(n)]
lines.sort() # O(NlogN)

sum = lines[0][1] - lines[0][0]
cur_e = lines[0][1]

for s, e in lines[1:]: # O(N)
    if e <= cur_e: continue # 선이 이전 범위 안에 포함될 때
    sum += e - max(cur_e, s)
    cur_e = max(e, cur_e)
print(sum)