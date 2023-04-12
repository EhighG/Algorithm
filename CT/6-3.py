import sys

def count_sort(arr):
  cnts = [[] for _ in range(101)]
  # cnts = [[]] * 101 # 주의! 원인은 모르겠지만, 모든 리스트가 같은 메모리 공간을 참조한다.
  for grade in arr:
    cnts[int(grade[1])].append(grade[0])
  result = ""
  for i in cnts:
    if (len(i) != 0):
      result += i[0] + " "
  return result

N = int(sys.stdin.readline())
grades = []

for i in range(N):
  grades.append(sys.stdin.readline().split())

result = count_sort(grades)
print(result)
