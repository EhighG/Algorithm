T = int(input())

for t in range(1, T+1):
    s = input().rstrip()
    cnt = 0
    for i in range(len(s)):
        if s[i] == '0': continue
        cmp = '1'
        cnt += 1
        for j in range(i+1, len(s)):
            if s[j] == cmp: continue
            cnt += 1
            cmp = s[j]
        break
    print(f"#{t} {cnt}")
