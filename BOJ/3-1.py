n = int(input())
cnt = 0

coin_types = [500,100,50,10]

for coin in coin_types:
    cnt += n // coin
    n %= coin

print(cnt)