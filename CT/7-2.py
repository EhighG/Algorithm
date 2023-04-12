import sys
# 1st way - O(N + M)
# def checkElems(arr):
#   isExist = [False for _ in range(1000001)] # 시간복잡도가 우선이므로
#   # isExist = [[False] for _ in range(1000001)] # 리스트 컴프리헨션 시 주의. False 대신 'None이 아닌 것' 이 되므로 조건문에서 True취급 됨.
#   for num in arr:
#     isExist[num] = True
#   return isExist

# N = int(sys.stdin.readline()) # 바로 int형변환 시 rstrip() 안붙여도 된다.
# exist_parts = list(map(int, sys.stdin.readline().split()))
# M = int(sys.stdin.readline())
# requested_parts = list(map(int, sys.stdin.readline().split()))

# isExist = checkElems(exist_parts) # boolean x 1,000,001
# result = ""
# for rp in requested_parts:
#   result += "yes" if isExist[rp] else "no"
#   result += " "

# print(result)

# 2nd way - O(M) / 생성 제외, in 연산(O(1)) * M번
n = int(sys.stdin.readline())
exist_parts = set(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())

result = ""

for request in list(map(int, sys.stdin.readline().split())):
  result += "yes" if request in exist_parts else "no" # set의 in 연산 = O(1) / set은 hashtable 기반 (https://stackoverflow.com/questions/3949310/how-is-set-implemented)
  result += " "

print(result)