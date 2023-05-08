import sys
input = sys.stdin.readline

T = int(input())

for t in range(T):
    n = int(input())
    arr = [*map(int, input().split())]

    sell_price = arr[-1]
    profit = 0
    for i in arr[-1::-1]:
        if i < sell_price:
            profit += sell_price - i
        else:
            sell_price = i
    print(profit)