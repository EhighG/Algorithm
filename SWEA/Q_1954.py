T = int(input())

def dfs(v, cnt, move_idx):
    # visited
    arr[v[0]][v[1]] = cnt

    # find next
    move = moves[move_idx]
    new_r = v[0] + move[0]
    new_c = v[1] + move[1]
    if 0 <= new_r < n and 0 <= new_c < n and arr[new_r][new_c] == 0:
        dfs((new_r,new_c), cnt+1, move_idx)
    else: # out of range or visited / max_turn_cnt = 1
        move_idx = (move_idx+1) % 4
        move = moves[move_idx]
        new_r = v[0] + move[0]
        new_c = v[1] + move[1]
        if 0 <= new_r < n and 0 <= new_c < n and arr[new_r][new_c] == 0:
            dfs((new_r, new_c), cnt+1, move_idx)



for t in range(1, T+1):
    n = int(input())
    arr = [[0]*n for _ in range(n)]
    moves = [[0,1], [1,0], [0,-1], [-1,0]] # 달팽이 방향대로
    cnt = 1
    dfs((0,0), cnt, 0)
    for row in arr:
        print(' '.join(map(str, row)))