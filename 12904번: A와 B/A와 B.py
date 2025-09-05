#  **************************************************************************  #
#                                                                              #
#                                                       :::    :::    :::      #
#    Problem Number: 12904                             :+:    :+:      :+:     #
#                                                     +:+    +:+        +:+    #
#    By: vheh502 <boj.kr/u/vheh502>                  +#+    +#+          +#+   #
#                                                   +#+      +#+        +#+    #
#    https://boj.kr/12904                          #+#        #+#      #+#     #
#    Solved: 2025/09/05 17:25:02 by vheh502       ###          ###   ##.kr     #
#                                                                              #
#  **************************************************************************  #


# Problem: A와 B
# 주어진 문자열 S를 T로 바꾸려고 한다.

# S에 두 가지 연산을 할 수 있다.
    # 1. 문자열의 뒤에 A를 추가한다.
    # 2. 문자열의 뒤에 B를 추가하고, 문자열을 뒤집는다.

import sys
input = sys.stdin.readline

s = list(input().rstrip())
t = list(input().rstrip())

switch = False
while t:
    if t[-1] == 'A':
        t.pop()
    elif t[-1] == 'B':
        t.pop()
        t.reverse()
    if s == t:
        switch = True
        break

if switch:
    print(1)
else: 
    print(0)