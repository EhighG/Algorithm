T = int(input())

for t in range(1, T+1):
    n = int(input().rstrip())
    board = []
    cnt = 0

    def put(depth):
        global cnt

        if depth == n:
            cnt += 1
            return

        for col in range(n):
            avail = True
            for i in range(depth):
                if board[i] == col or depth-i == abs(col - board[i]):
                    avail = False
                    break
            if not avail: continue
            board.append(col)
            put(depth+1)
            board.pop()

    put(0)
    print(f"#{t} {cnt}")
