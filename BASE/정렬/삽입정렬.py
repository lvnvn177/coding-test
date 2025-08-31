arrary = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(1, len(arrary)):
    for j in range(i, 0, -1): # 인덱스 i부터 1까지 감소하여 반복하는 문법
        if arrary[j] < arrary[j - 1]: # 한 칸씩 왼쪽으로 이동 
            arrary[j], arrary[j - 1] = arrary[j - 1], arrary[j]
        else: # 자기보다 작은 데이터를 만나면 그 위치에서 멈춤
            break

print(arrary)