import sys
input = sys.stdin.readline

n, m = map(int, input().split())
r, c, d = map(int, input().split())
room = [[*map(int, input().split())] for _ in range(n)]

moves = [(-1, 0), (0, 1), (1, 0), (0, -1)] # 북동남서

cnt = 0
while True:
    if room[r][c] == 0:
        cnt += 1
        room[r][c] = -1

    # 주변 살피기
    found = False
    for i in range(4):
        # 전방 탐색이 아닌 회전부터
        d = (d - 1) if d != 0 else 3
        nr, nc = r + moves[d][0], c + moves[d][1]
        if room[nr][nc] != 0: continue

        # 찾았으면
        found = True
        r, c = nr, nc
        break
    if found: continue

    # 주변이 다 깨끗할 때
    tmp_d = (d+2) % 4
    nr, nc = r + moves[tmp_d][0], c + moves[tmp_d][1]

    # 후진 불가면 stop
    if room[nr][nc] == 1:
        break
    # 후진 가능하면 후진
    r, c = nr, nc
print(cnt)