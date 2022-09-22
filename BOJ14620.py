import itertools
from sys import stdin

n=int(stdin.readline())
dy=[1, 0, -1, 0]
dx=[0, 1, 0, -1]
board=[]
for i in range(n):
    board.append(list(map(int, stdin.readline().split())))

Min=1000000000
coordinatesList=list(itertools.combinations([(i, j) for i in range(1, n-1) for j in range(1, n-1)], 3))
for coordinates in coordinatesList:
    possible=True
    result=0
    check=[[False for i in range(n)] for j in range(n)]
    for coordiante in coordinates:
        if not check[coordiante[0]][coordiante[1]] and not check[coordiante[0]+dy[0]][coordiante[1]+dx[0]] and not check[coordiante[0]+dy[1]][coordiante[1]+dx[1]] and not check[coordiante[0]+dy[2]][coordiante[1]+dx[2]] and not check[coordiante[0]+dy[3]][coordiante[1]+dx[3]]:
            check[coordiante[0]][coordiante[1]]=True
            check[coordiante[0]+dy[0]][coordiante[1]+dx[0]]=True
            check[coordiante[0]+dy[1]][coordiante[1]+dx[1]]=True
            check[coordiante[0]+dy[2]][coordiante[1]+dx[2]]=True
            check[coordiante[0]+dy[3]][coordiante[1]+dx[3]]=True
            result+=board[coordiante[0]][coordiante[1]]+board[coordiante[0]+dy[0]][coordiante[1]+dx[0]]+board[coordiante[0]+dy[1]][coordiante[1]+dx[1]]+board[coordiante[0]+dy[2]][coordiante[1]+dx[2]]+board[coordiante[0]+dy[3]][coordiante[1]+dx[3]]
        else:
            possible=False
            break
    if possible:
        Min=min(Min, result)
print(Min)
