import sys
input = sys.stdin.readline

N =int(input())
villages = [tuple(map(int, input().split())) for _ in range(N)]
villages.sort(key=lambda x: x[0])

if N == 1:
    ans = 0
    if villages[0][1] == 0:
        ans = -1000000000
    else:
        ans = villages[0][0]
    print(ans)
    exit(0)

cur = len(villages)//2
left, right = 0, 0

all_same = True
for v in villages[:cur]:
    if v[1] != villages[0][1]: all_same = False
    left += v[1]
for v in villages[cur+1:]:
    if v[1] != villages[0][1]: all_same = False
    right += v[1]
if villages[cur][1] != villages[0][1]: all_same = False

if all_same:
    print(villages[0][0])
    exit(0)

move = -1 if left > right else 1
to_side = max(left, right)
from_side = min(left, right) + villages[cur][1]

while to_side > from_side: # 양 side의 인구 수 비교
    if villages[cur][1] == villages[cur+move][1]:
        cur += min(move, 0)
    cur += move
    to_side -= villages[cur][1]
    from_side += villages[cur][1]
print(villages[cur][0])
