import sys
input = sys.stdin.readline

N, L = map(int, input().split())
arr = [tuple(map(int, input().split())) for _ in range(N)]

arr.sort()

covered_l = 0
cnt = 0

for i in arr:
    s, e = i
    if covered_l >= e-1: continue
    covered_l = max(covered_l, s-1)
    need_cnt = (e-1-covered_l)//L
    if covered_l + (need_cnt*L) < e-1: # 나누어 떨어지지 않을 때
        need_cnt += 1
    covered_l += need_cnt*L
    cnt += need_cnt
print(cnt)