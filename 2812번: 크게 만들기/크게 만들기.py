#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 2812                              :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: vheh502 <boj.kr/u/vheh502>                  +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/2812                           #+#        #+#      #+#     #
#    Solved: 2025/09/03 15:48:42 by vheh502       ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #

# K : 제거할 숫자의 개수
# 그리드 
# 각 자리 수를 하나씩 지워보면서 탐색 
# 최대한 큰 수가 앞자리에 있어야함 
# 어떻게 지우든 자릿수는 동일 


N, K = map(int, input().split())

numbers = list(input())
answer = []

for number in numbers:
    while (len(answer) > 0 and answer[-1] < number and K > 0):
        answer.pop()
        K -= 1
    answer.append(number)

while (K > 0):
    answer.pop()
    K -= 1

print(''.join(answer))

