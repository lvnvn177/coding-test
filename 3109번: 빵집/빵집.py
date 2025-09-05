#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 3109                              :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: vheh502 <boj.kr/u/vheh502>                  +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/3109                           #+#        #+#      #+#     #
#    Solved: 2025/09/05 17:40:32 by vheh502       ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #



import sys

def dfs(x, y):
    global answer

    arr[x][y] = '0'

    if y == c - 1: # 끝까지 도달
        answer += 1 # 정답 개수 증가
        return True # 도달했다고 알림
    
    for i in range(3):
        nx=x+dx[i]
        ny=y+dy[i]

        if nx < 0 or nx >= r or nx<0 or ny>=c:
            continue

        if arr[nx][ny] == '.':
            if dfs(nx, ny): # 이 곳에서 시작된 것이 끝까지 도달
                return True # 해당 (x, 0) 에서 시작된 경로 고정 후 탈출
    
    return False 



# main
r, c = map(int, sys.stdin.readline().split())
arr= []
for _ in range(r):
    arr.append(list(sys.stdin.readline().rstrip()))

dx = [-1, 0, 1]
dy = [1, 1, 1]

answer = 0
for i in range(r):
    dfs(i, 0)

print(answer)