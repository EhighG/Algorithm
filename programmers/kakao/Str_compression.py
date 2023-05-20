
def solution(s):
    n = len(s)
    if n == 1: return 1
    results = []
    for l in range(1, n):
        i = 0
        sub = []
        res = ""
        # slicing
        while i+l <= n:
            sub.append(s[i:i+l])
            i += l
        # cmp
        i2 = 0
        while i2 < len(sub):
            cnt = 1
            for j in range(i2+1, len(sub)):
                if sub[i2] != sub[j]: break
                cnt += 1
            if cnt != 1:
                res += str(cnt)
            res += sub[i2]
            i2 += cnt
        # 나머지 붙이기
        if i != n: # 나머지가 있으면
            res += s[i:]
        results.append(res)

    # find min_len
    min_len = 1001
    for i in range(len(results)):
        if len(results[i]) < min_len:
            min_len = len(results[i])
    return min_len


while True:
    s1 = input().rstrip()
    print(solution(s1))