# import sys
# input = sys.stdin.readline
#
# # 풀이 1: O(N*K)
# # case 1) 이미 해당 기기가 꽂혀 있다 -> continue
# # case 2) 안 꽂혀있으나, 자리가 있다 -> 꽂고, continue
# # case 3) 자리가 없다 -> 다음 사용이 가장 뒤인 것과 교체
#
# # 입력 & 전처리
# n, k = map(int, input().split())
# plan = [*map(int, input().split())]
# plan_foreach = dict() # latest_stuff를 빠르게 찾기 위함
# hole = set()
#
# tmp_set = set()
# for i in range(k-1, -1, -1): # reverse; 이후 pop연산 효율 때문
#     if plan[i] not in tmp_set:
#         plan_foreach[plan[i]] = [i]
#         tmp_set.add(plan[i])
#     else:
#         plan_foreach[plan[i]].append(i)
#
# # 본 로직
# cnt = 0
# for i in range(0, k): # O(K)
#     plan_foreach[plan[i]].pop()
#
#     if len(hole) == n and plan[i] not in hole:
#         # latest(next) 인 기기 찾기
#         latest_stuff = 0
#         latest_idx = -1
#         for j in hole: # O(N*K)
#             if not plan_foreach[j]: # 더 쓸 일 없을 때
#                 latest_stuff = j
#                 break
#             cur_idx = plan_foreach[j][-1]
#             if cur_idx > latest_idx:
#                 latest_stuff = j
#                 latest_idx = cur_idx
#         # 교체
#         hole.remove(latest_stuff)
#         hole.add(plan[i])
#         cnt += 1
#     elif len(hole) < n:
#         hole.add(plan[i]) # 중복 고려할 필요 x
#
# print(cnt)


# 풀이 2: 가독성 더 좋고, '123123456456' 처럼 연속은 없고 숫자가 몰아서 나올 때 빠름.
# 같은 숫자의 연속이 많거나, '123456789123' 처럼 다음 순서를 멀리 탐색해야 할 때(inner 반복문의 반복 수가 늘어날 때) 느릴 듯

n, k = map(int, input().split())
seq = [*map(int, input().split())]
hole = set()

cnt = 0
for i in range(k): # O(K)
    if len(hole) == n and seq[i] not in hole:
        # 교체
        will_use = set() # 각 기기의 첫 번째 사용 idx만 비교하기 위함
        pop = -1
        for j in range(i+1, k):
            if seq[j] in hole: # 현재 꽂혀있는 것들 중에서 비교해야 하므로
                pop = seq[j]
                will_use.add(pop) # 기기별 가장 앞의 idx가 아니면 무시된다.
                if len(will_use) == n:
                    break
        if len(will_use) == n:
            hole.remove(pop) # for문 안에서 처리하면, 정상 처리된 경우와 더이상 사용 안하는 것이 있는 경우 구분 불가
        else:
            for pop in hole - will_use:
                hole.remove(pop)
                break # 하나씩 빼는 이유: 마지막쯤에 남은 seq 개수보다 cnt가 많이 증가되는 것 방지
        cnt += 1
    hole.add(seq[i])
print(cnt)





