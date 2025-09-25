#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 1931                              :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: vheh502 <boj.kr/u/vheh502>                  +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/1931                           #+#        #+#      #+#     #
#    Solved: 2025/09/05 21:30:41 by vheh502       ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #



N = int(input())

meetings = []

for _ in range(N):
    start,  end = map(int, input().split(" "))
    meetings.append((start, end))

# 종료 시간을 오름차순 정렬하고, 시작 시간을 오름차순 정렬합니다
meetings.sort(key=lambda x: (x[1], x[0]))

time = 0
answer = 0
for meeting in meetings:
    if time <= meeting[0]:
        time = meeting[1]
        answer += 1
print(answer)
