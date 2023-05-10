import sys

input = sys.stdin.readline


# def laterdate(t1, t2):  # t = (month, day)
#     """return later date if they're different, else 0"""
#     if t1[0] == t2[0]:
#         if t1[1] == t2[1]: return 0
#         return t1 if t1[1] > t2[1] else t2
#     return t1 if t1[0] > t2[0] else t2
#
#
# n = int(input())
# flowers = []
#
# for i in range(n):
#     sm, sd, em, ed = map(int, input().split())
#     flowers.append(((sm, sd), (em, ed)))
# flowers.sort(reverse=True)
#
# cnt = 0
# range_e = (3, 1)
# while flowers:
#     # flower가 남았지만, 기간을 다 커버 못 할 때
#     if laterdate(range_e, flowers[-1][0]) == flowers[-1][0]:
#         break
#
#     max_e = (1, 1)
#     while flowers:  # True && 'flower가 존재한다' 는 조건
#         if laterdate(flowers[-1][0], range_e) == flowers[-1][0]:
#             break
#         flower = flowers.pop()
#         tmp = laterdate(max_e, flower[1])
#         if tmp != 0:
#             max_e = tmp
#
#     cnt += 1
#     range_e = max_e
#     if laterdate(range_e, (11, 30)) == range_e:
#         break
#
# # 기간을 다 커버 못했을 때
# if laterdate(range_e, (11,30)) != range_e: # 0 or (11,30)
#     print(0)
# else:
#     print(cnt)

# 풀이 2: 전처리 귀찮지만, 빠른 풀이(inner 반복문 없음, 리스트 안 튜플 없음)

days=[0,31,28,31,30,31,30,31,31,30,31,30,31]
for i in range(1,12):
    days[i] = days[i-1] + days[i] # days = 각 달의 마지막까지의 일수

n = int(input())
flowers = [0]*366 # flowers[i] = i일에 피는 꽃이 지는 날짜의 max값
for i in range(n):
    sm, sd, em, ed = map(int, input().split())
    flowers[days[sm-1]+sd] = max(days[em-1]+ed, flowers[days[sm-1]+sd]) # 피는 날짜가 같을 때, 최대값만 남기기

period_e = 60
cur_max = 0
cnt = 0
for i in range(1, 366):
    cur_max = max(cur_max, flowers[i])
    if i == period_e:
        if cur_max > period_e:
            cnt += 1
            if cur_max > 334: # 334 = 11/29
                break
            period_e = cur_max
            continue
        else: # 더 이상 피어있을 수 있는 꽃이 없을 때
            break

print(cnt if cur_max > 334 else 0)