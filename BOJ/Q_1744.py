import sys
input = sys.stdin.readline

n = int(input())
arr1 = []
arr2 = []
result = 0

for i in range(n):
    x = int(input())
    if x < 0: arr1.append(x)
    else: arr2.append(x)

# 마지막엔 절대값이 가장 작은 수가 남아야 한다.
arr1.sort(reverse=True)
arr2.sort()

while len(arr1) > 1:
    result += arr1.pop() * arr1.pop()

# 남은 음수 처리
lastMinus = 0
if arr1: lastMinus = arr1[0]

if not arr2:
    print(result + lastMinus)
    exit(0)

if arr2[0] != 0: result += lastMinus

# 0, 1 처리
i = 0
while i < len(arr2) and arr2[i] < 2:
    result += arr2[i]
    i += 1
arr2 = arr2[i:]

while len(arr2) > 1:
    result += arr2.pop() * arr2.pop()

if arr2: # 한 개가 남았을 때
    result += arr2.pop()

print(result)