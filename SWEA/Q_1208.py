
tc = 10
for t in range(1, tc+1):
    n = int(input().rstrip())
    lst = [*map(int, input().split())]
    lst = sorted(lst)
    for i in range(n):
        if lst[-1] - lst[0] < 2: break
        lst[0] += 1
        lst[-1] -= 1
        lst = sorted(lst)
    print(f"#{t} {lst[-1] - lst[0]}")
