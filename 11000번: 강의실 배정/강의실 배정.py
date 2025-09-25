#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 11000                             :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: vheh502 <boj.kr/u/vheh502>                  +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/11000                          #+#        #+#      #+#     #
#    Solved: 2025/09/09 12:36:48 by vheh502       ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #

# S~T 에 끝나는 N개의 수업 
# 수업 시간 : S ~ T (0 ≤ S < T ≤ 1,000,000,000)

# Key
# 1. 시작시간 순서대로 강의실을 배정 
# 2. 진행 중인 강의의 끝나는 시간과 새로운 강의의 시작 시간 비교 
# 3. 이를 위해 강의 시작 시간 기준으로 정렬
# 4. 진행 중인 강의의 끝나는 시간과 비교할 우선 순위가 가장 높은 강의를 비교해야함 -> 우선순위 큐
# 5. 우선순위 큐를 활용하여 다음 상황을 처리
## Task
## 1. 끝시간 < 시작 시간 -> 새로운 강의실 배정 
## 2. 끝시간 > 시작 시간 -> 기존 강의 제거 및 새로운 강의 삽입 


import sys, heapq

input = sys.stdin.readline

N = int(input())

lecture = []
room = []

lecture = sorted([list(map(int, sys.stdin.readline().split())) for _ in range(N)])


heapq.heappush(room, lecture[0][1]) # 첫 강의 끝나는 시간

for i in range(1, N):
    if lecture[i][0] < room[0]: # 새로운 강의의 시작 시간 < 현재 강의 끝나는 시간
        heapq.heappush(room, lecture[i][1]) # 새로운 강의실 넣기
    else: 
        heapq.heappop(room) # 기존 강의 제거 
        heapq.heappush(room, lecture[i][1]) # 새로운 강의 삽입

print(len(room))


