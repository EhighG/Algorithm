# 배열 돌리기 3
# 연산 1,2) 상하/좌우 반전
# u&d/l&r 두고 끝부터 대소관계 바뀔때까지 swap

# 연산 3) 오른쪽 회전
# (이중 for문일 때) arr[i,j] -> arr[j, len(wid)-1-i]

# 연산 4) 왼쪽 회전
# arr[i,j] = arr[len(hei)-1-j, i]

# 연산 5) sector 오른쪽 회전
# 1sec: [i,j] -> [i+half(wid), j]
# 2sec: [i,j] -> [i, j+half(hei)]
# 3sec: [i,j] -> [i-half(wid), j]
# 4sec: [i,j] -> [i. j-half(hei)]

# 연산 6) sector 왼쪽 회전
# 1sec: [i,j] -> [i, j+half(hei)]
# 2sec: [i,j] -> [i-half(wid), j]
# 3sec: [i,j] -> [i, j-half(hei)]
# 4sec: [i,j] -> [i+half(wid), j]

# 시간복잡도 -
# n,m = max 100x100, r = max 1000 -> max 10000000

# 특이사항 - 
# 반전 연산(1,2) -> 같은 연산 2번이면 무효
# 회전 연산(3~6) -> 같은거 4번 or 반대방향 연속 -> 무효

class Arr:
  
  def __init__(self, arr):
    self.arr = arr
    self.wid = len(arr[0])
    self.hei = len(arr)

  def toString(self):
    result = ""
    for i in self.arr:
      for j in i:
        result += str(j) + " "
      result += "\n"
    return result
      
  
  def reverse_ver(self):
    # arr = self.arr # shallow copy
    # up, down = 0, self.hei-1
    
    # while (up < down):
    #   arr[up], arr[down] = arr[down], arr[up] # swap / 제대로 되는지 체크
    #   up += 1
    #   down -= 1

    self.arr = self.arr[::-1] # deepcopy

  def reverse_hor(self):
    # arr = self.arr
    # left, right = 0, self.wid-1

    # while (left < right):
    #   for i in range(len(arr)):
    #     arr[i][left], arr[i][right] = arr[i][right], arr[i][left]
    #   left += 1
    #   right -= 1
    self.arr = [arr[::-1] for arr in self.arr]
    # self.arr = list(map(lambda x: x[::-1], arr))

    

  def rotate_left(self):
    # arr = [[0]*self.hei for _ in range(self.wid)]
    # for i in range(self.hei):
    #   for j in range(self.wid):
    #     arr[len(arr)-1-j][i] = self.arr[i][j]
    
    # self.arr = arr
    
    # python style
    self.arr = list(zip(*self.arr))[::-1]
    
    # width, height도 업데이트
    self.wid = len(self.arr[0])
    self.hei = len(self.arr)
    

  def rotate_right(self):
    # arr = [[0]*self.hei for _ in range(self.wid)] # size = 8, 6
    # for i in range(self.hei): # 6
    #   for j in range(self.wid): # 8
    #     arr[j][len(arr[0])-1-i] = self.arr[i][j]

    # self.arr = arr

    # python style
    self.arr = list(zip(*self.arr[::-1]))
    
    self.wid = len(self.arr[0])
    self.hei = len(self.arr)

  def sector_rotate_left(self):
    # arr = [[0]*self.wid for _ in range(self.hei)]
    # for i in range(self.hei):
    #   for j in range(self.wid):
    #     cur = self.arr[i][j]
    #     half_wid = self.wid//2
    #     half_hei = self.hei//2
    #     if i < half_hei: # sec 1,2
    #       if j < half_wid: # sec 1 -> 4
    #         arr[i+half_hei][j] = cur
    #       else: # sec 2 -> 1
    #         arr[i][j-half_wid] = cur
    #     else: # sec 3,4
    #       if j >= half_wid: # sec 3 -> 2
    #         arr[i-half_hei][j] = cur
    #       else: # sec 4 -> 3
    #         arr[i][j+half_wid] = cur
    sec1 = map(lambda x: x[:self.wid//2], self.arr[:self.hei//2])
    sec2 = map(lambda x: x[self.wid//2:], self.arr[:self.hei//2])
    sec3 = map(lambda x: x[self.wid//2:], self.arr[self.hei//2:])
    sec4 = map(lambda x: x[:self.wid//2], self.arr[self.hei//2:])

    self.arr = list(zip(sec2, sec3)) + list(zip(sec1, sec4))
    self.arr = list(map(lambda x: x[0] + x[1], self.arr))

  def sector_rotate_right(self):
    # arr = [[0]*self.wid for _ in range(self.hei)]
    # for i in range(self.hei):
    #   for j in range(self.wid):
    #     cur = self.arr[i][j]
    #     half_wid = self.wid//2
    #     half_hei = self.hei//2
    #     if i < half_hei: # sec 1,2
    #       if j < half_wid: # sec 1 -> 2
    #         arr[i][j+half_wid] = cur
    #       else: # sec 2 -> 3
    #         arr[i+half_hei][j] = cur
    #     else: # sec 3,4
    #       if j >= half_wid: # sec 3 -> 4
    #         arr[i][j-half_wid] = cur
    #       else: # sec 4 -> 1
    #         arr[i-half_hei][j] = cur
            
    # self.arr = arr
    sec1 = map(lambda x: x[:self.wid//2], self.arr[:self.hei//2])
    sec2 = map(lambda x: x[self.wid//2:], self.arr[:self.hei//2])
    sec3 = map(lambda x: x[self.wid//2:], self.arr[self.hei//2:])
    sec4 = map(lambda x: x[:self.wid//2], self.arr[self.hei//2:])

    self.arr = list(zip(sec4, sec1)) + list(zip(sec3, sec2)) # self.arr = list(tuple(list()))
    self.arr = list(map(lambda x: x[0] + x[1], self.arr))

import sys
input = sys.stdin.readline
N, M, R = map(int, input().split())
i_arr = [list(map(int, input().split())) for _ in range(N)]

m_arr = Arr(i_arr)

opers = {'1': m_arr.reverse_ver,
         '2': m_arr.reverse_hor,
         '3': m_arr.rotate_right,
         '4': m_arr.rotate_left,
         '5': m_arr.sector_rotate_right,
         '6': m_arr.sector_rotate_left}

for i in input().split():
  func = opers.get(i)
  func()

print(m_arr.toString(), end="")
