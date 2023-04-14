import math
 
T = int(input())
for test_case in range(1, T + 1):
  
  N = int(input())
  cost = N - 1
  
  for i in range(round(math.sqrt(N))+1, 1, -1): # 가운데에 가까운 것일수록, 절약되는 cost가 크다((1, 100)과 (4, 25)처럼)
    if N % i == 0:
      cost = (N // i) + i - 2
      break
      
  print(f"#{test_case} {cost}")