from copy import deepcopy
from sys import stdin      
input=stdin.readline

R, C, M=map(int, input().split())

board=[[(0, 0, 0) for _ in range(C+1)] for _ in range(R+1)]
for _ in range(M):
    r, c, s, d, z=map(int, input().split())
    board[r][c]=(s, d, z)


dy=[0, -1, 1, 0, 0]
dx=[0, 0, 0, 1, -1]
result=0
for king in range(1, C+1):
    for i in range(1, R+1):
        if board[i][king]!=(0, 0, 0):
            result+=board[i][king][2]
            board[i][king]=(0, 0, 0)
            break
    # print(king, result)
    # for i in range(1, R+1):
    #     print(*board[i][1:])
    # print()

    temp=[[(0, 0, 0) for _ in range(C+1)] for _ in range(R+1)]
    for i in range(1, R+1):
        for j in range(1, C+1):
            if board[i][j]!=(0, 0, 0):
                shark=board[i][j]
                nextY=i+dy[shark[1]]*shark[0]
                nextX=j+dx[shark[1]]*shark[0]
                nextD=shark[1]
                # print(nextY, nextX)
                if nextY>R:
                    s=shark[0]
                    s=s-(R-i)
                    sQ=s//(R-1)
                    sR=s%(R-1)
                    if sQ%2==1:
                        nextY=1+sR
                    else:
                        nextY=R-sR
                        nextD=nextD%2+1
                elif nextY<=0:
                    s=shark[0]
                    s=s-(i-1)
                    sQ=s//(R-1)
                    sR=s%(R-1)
                    if sQ%2==0:
                        nextY=1+sR
                        nextD=nextD%2+1
                    else:
                        nextY=R-sR
                elif nextX>C:
                    s=shark[0]
                    s=s-(C-j)
                    sQ=s//(C-1)
                    sR=s%(C-1)
                    if sQ%2==1:
                        nextX=1+sR
                    else:
                        nextX=C-sR
                        nextD=nextD%2+3
                elif nextX<=0:
                    s=shark[0]
                    s=s-(j-1)
                    sQ=s//(C-1)
                    sR=s%(C-1)
                    if sQ%2==0:
                        nextX=1+sR
                        nextD=nextD%2+3
                    else:
                        nextX=C-sR
                # print(nextY, nextX)
                # print()
                if temp[nextY][nextX]==(0, 0, 0):
                    temp[nextY][nextX]=(shark[0], nextD, shark[2])
                else:
                    if temp[nextY][nextX][2]<shark[2]:
                        temp[nextY][nextX]=(shark[0], nextD, shark[2])
    board=deepcopy(temp)
print(result)
