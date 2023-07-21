import sys
import copy
import itertools
input = sys.stdin.readline

# # 풀이 1
# L, C = map(int, input().split())
#
# chars = list(input().split())
# chars.sort()
# used = [False] * C
#
# selected = []
# moeum = ('a', 'e', 'i', 'o', 'u')
#
# res = [] # list(list(char))
#
# def dfs(l):
#     # 사전순, 중복 체크
#     dict_max = 0
#     for c in selected:
#         dict_val = ord(c)
#         if dict_val < dict_max: return # 마지막 선택 되돌리기
#         dict_max = dict_val
#     # 다 선택했을 때, 자/모음 개수 체크
#     if l >= L:
#         moeum_cnt = 0
#         for c in selected:
#             if c in moeum:
#                 moeum_cnt += 1
#         if moeum_cnt < 1 or moeum_cnt > l-2: return
#         # 조건이 모두 맞다면
#         # res.append(''.join(selected))
#         res.append(copy.deepcopy(selected))
#         return
#
#     # 아직 선택 남음
#     for i in range(C):
#         if used[i]: continue
#         # 선택
#         selected.append(chars[i])
#         used[i] = True
#         dfs(l+1)
#         # 되돌리기
#         selected.remove((chars[i]))
#         used[i] = False
#
# dfs(0)
# # res = sorted(res)
# for s in res:
#     print(''.join(s))

# 풀이 2
# itertools.combinations() 사용 -> 중복 체크 불필요, 문자열 sort -> 문자 sort로 변경
L, C = map(int, input().split())
chars = list(input().split()) # list(string)
chars.sort()
res = []

moeum = set(('a','e','i','o','u'))

for string in itertools.combinations(chars, L):
    moeum_cnt = 0
    for c in string:
        if c in moeum:
            moeum_cnt += 1
    if moeum_cnt < 1 or L-2 < moeum_cnt: continue
    res.append(''.join(string))

print('\n'.join(res))


