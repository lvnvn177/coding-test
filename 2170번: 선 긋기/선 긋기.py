#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 2170                              :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: vheh502 <boj.kr/u/vheh502>                  +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/2170                           #+#        #+#      #+#     #
#    Solved: 2025/09/09 10:18:45 by vheh502       ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #



import sys
input = sys.stdin.readline

n = int(input())    # number of lines
lines = [] # list of lines
ans = 0 # answer 

for _ in range(n): # read lines and store them as tuples 
    lines.append(tuple(map(int, input().split())))

lines.sort()

start, end = lines[0] # smallest start 

for i in range(1, n): # 각 줄을 확인
    s, e = lines[i]

    if s <= end: # 겹치는 경우 
        end = max(e, end) # 끝점을 갱신 
    else : # 겹치치 않는 경우
        ans += end - start # 길이 업데이트 
        start, end = s, e # 시작점, 끝점 갱신

ans += (end - start)
print(ans)