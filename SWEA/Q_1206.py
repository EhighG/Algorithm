# 27 min
T = 10
for test_case in range(1, T + 1):

    N = int(input())
    buildings = list(map(int, input().split()))
    result = 0
    
    for i in range(2, len(buildings)-2):
        max_h_nearby = 0 # 좌우 2칸
        for nearby in range(i-2, i+3):
            if nearby == i: continue
            max_h_nearby = max(buildings[nearby], max_h_nearby)
        diff = buildings[i] - max_h_nearby
        result += max(diff, 0)
        
    print(f"#{test_case} {result}")