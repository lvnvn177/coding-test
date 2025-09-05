#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 2012                              :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: vheh502 <boj.kr/u/vheh502>                  +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/2012                           #+#        #+#      #+#     #
#    Solved: 2025/09/02 21:09:41 by vheh502       ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #


import sys
N = int(sys.stdin.readline())
rank = sorted([int(sys.stdin.readline()) for _ in range(N)])
cnt = 0
for i in range(N):
    if rank[i] != i + 1:
        cnt += abs (rank[i] - (i + 1))
print(cnt)


