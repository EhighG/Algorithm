n = int(input().rstrip())
farm = [[*map(int, input())] for _ in range(n)]
mid = n // 2
res = sum(farm[mid])

for i in range(1, mid+1):
    res += sum(farm[mid-i][i:n-i])
    res += sum(farm[mid+i][i:n-i])

print(f"#{1} {res}")

