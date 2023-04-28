E, S, M = map(int, input().split())
n = 1

# # 오답 : E, S, M이 각각 범위 최대값(15, 28, 19)일 때, 무한루프
# while True:
#   if n % 15 == E and n % 28 == S and n % 19 == M: break
#   n += 1

# 정답 :
while True:
  if (n-E) % 15 == 0 and (n-S) % 28 == 0 and (n-M) % 19 == 0: break
  n += 1
print(n)