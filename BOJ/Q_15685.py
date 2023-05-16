# 풀이: O(N * 2^10)
# 1) pattern (= arr[n][2^n]) 초기화
# 2) input 커브마다, 시작점 & 방향 고려하여 map의 각 좌표 visited체크
# #) 사각형 수 체크

import sys
input = sys.stdin.readline

# 입력받기
n = int(input())
curves = [tuple(map(int, input().split())) for _ in range(n)]

# 필요한 요소 초기화(patterns, moves, visited)
max_gen = 0
for c in curves:
    if c[-1] > max_gen: max_gen = c[-1]

patterns = [[0]] # pattern of gen(0)
for g in range(1,max_gen+1):
    # print(f"len(patterns) = {len(patterns)}, g-1 = {g-1}")
    pat = patterns[g-1]
    for p in patterns[g-1][::-1]:
        pat.append(p+1)
    patterns.append(pat)

moves = [(0,1), (-1,0), (0,-1), (1,0)] # 우 상 좌 하

visited = [[False]*100 for _ in range(100)]

# 커브 그리기(visited 체크)
for curve in curves:
    cur_x, cur_y = curve[0]-1, curve[1]-1
    d, g = curve[2:]
    for i in patterns[g]:
        visited[cur_x][cur_y] = True
        move = moves[(i+d) % 4]
        cur_x += move[0]
        cur_y += move[1]

# 사각형 체크
moves = [(0,1), (1,0), (0,-1), (-1,0)]
cnt = 0
for row in range(99): # 사각형 면적 고려
    for col in range(99):
        cur = [row, col]
        is_rec = True
        for move in moves:
            if not visited[cur[0]][cur[1]]: break
            cur[0] += move[0]
            cur[1] += move[1]
        if is_rec: cnt += 1
print(cnt)