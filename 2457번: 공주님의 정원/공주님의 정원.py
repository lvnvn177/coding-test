#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 2457                              :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: vheh502 <boj.kr/u/vheh502>                  +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/2457                           #+#        #+#      #+#     #
#    Solved: 2025/09/05 21:59:25 by vheh502       ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #

# 3월 1일 부터 11월 30일 까지 매일 꽃이 한 가지 이상 피어있어야함
# 최소한의 꽃의 개수를 구해야함 
# 1 1 5 31 계산 ->  월에 x 100 을하여 101 ~ 531 까지의 범위로 생각
# 시작하는 날 start 부터
 

import heapq
n = int(input())
memo = []
for _ in range(n):
    a, b, c, d = map(int, input().split())
    a *= 100
    c *= 100
    memo.append([a+b, c+d]) # [시작일, 끝나는일]
memo.sort(key=lambda x:(x[0], x[1])) 
cnt = 0
end = 0
start = 301

while memo:
    if start > 1130 or start < memo[0][0]: break # 11월 30일이 지나거나 시작일이 가장 빠른 꽃보다 빠르면 종료

    for _ in range(len(memo)): # 가장 빨리 피는 꽃부터 확인
        if start >= memo[0][0]:
            if end <= memo[0][1]:
                end = memo[0][1]
            memo.remove(memo[0])
        else:
            break
    start = end
    cnt += 1
if start <= 1130:
    print(0)
else:
    print(cnt)
