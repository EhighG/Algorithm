import sys
input = sys.stdin.readline

N = int(input())
K = int(input())
sensors = [*map(int, input().split())]
sensors.sort()
default_len = sensors[-1] - sensors[0]

# 제외할 구간 찾기
gaps = []
for i in range(N-1):
    gaps.append(sensors[i+1]-sensors[i])
gaps.sort(reverse=True)
gaps = gaps[:min(N,K-1)]

# 계산
ans = default_len - sum(gaps)
print(ans)
