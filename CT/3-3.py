N, M = map(int, input().split())
mins = list()

for i in range(N):
  arr = list(map(int, input().split()))
  mins.append(min(arr))

print(max(mins))