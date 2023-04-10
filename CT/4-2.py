import time

N = int(input())
h = M = s = 0
cnt = 0

sTime = time.time()

# while h <= N:
#   # clock 구현
#   s += 1
#   if (s >= 60):
#     M += 1
#     s %= 60
#   if (M >= 60):
#     h += 1
#     M %= 60
#   # 3 체크
#   s1 = str(h) + str(M) + str(s)
#   for c in s1:
#     if c == "3":
#       cnt += 1
#       break

# 더 빠름(clock 구현부분 연산이 간소화됨)
for h in range(N+1):
  for M in range(60):
    for s in range(60):
      if "3" in str(h)+str(M)+str(s):
        cnt += 1

eTime = time.time()

print(cnt)
print(f"time = {eTime - sTime}")